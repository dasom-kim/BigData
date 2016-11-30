package lab09;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Similarity {

	public static class TokenizerMapper extends
			Mapper<Object, Text, Text, VectorWritable> {

		private Text emitKey = new Text();
		private VectorWritable emitVal = new VectorWritable();
		private double[] point = null;

		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {

			String[] arr = value.toString().split("\t");
			point = new double[arr.length];

			for (int i = 0; i < arr.length; i++) {
				point[i] = Double.parseDouble(arr[i]);
			}

			emitVal.vec = point;

			int Partnum = (int) Double.parseDouble(arr[0]) % 10;

			for (int i = 0; i < arr.length; i++) {
				if (Partnum < i) {
					emitKey.set(Partnum + "," + i);
				} else {
					emitKey.set(i + "," + Partnum);
				}

				context.write(emitKey, emitVal);
			}

		}
	}

	public static class ReducerClass extends
			Reducer<Text, VectorWritable, Text, DoubleWritable> {

		private Text pointvalue = new Text();
		private DoubleWritable result = new DoubleWritable();

		public void reduce(Text key, Iterable<VectorWritable> values,
				Context context) throws IOException, InterruptedException {

			HashMap<Integer, String> Points = new HashMap<Integer, String>();			
			double dist = 0;
			int temp = 0;

			for (VectorWritable val : values) {
				Points.put(temp, val.toString());
				temp += 1;
			}

			for (int i = 0; i < Points.size(); i++) {
				String value1 = Points.get(i);
				String[] pointsvalue1 = value1.split("\t");
				
				for (int j = 0; j < Points.size(); j++) {
					if (j > i) {
						String value2 = Points.get(j);
						String[] pointsvalue2 = value2.split("\t");
						
						dist = computeDistance(pointsvalue1, pointsvalue2, pointsvalue2.length);
						
						if (dist < 20) {
							pointvalue.set("("+ value1 + " , " + value2 +")");
							result.set(dist);
							
							context.write(pointvalue, result);
						}
					}
				}
			}
		}
	}

	public static double computeDistance(String[] arr1, String[] arr2, int d) {
		if (arr1.length < d || arr2.length < d)
			return -1;

		double sum = 0;
		for (int i = 0; i < d; i++) {
			double value1 = Double.parseDouble(arr1[i]);
			double value2 = Double.parseDouble(arr2[i]);
			
			sum += (value1 - value2) * (value1 - value2);
		}

		sum = Math.sqrt(sum);
		return sum;
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration(); // job 수행하기 위한 설정 초기화
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
		if (otherArgs.length != 2) {
			System.err.println("Usage: Similarity measure <in> <out>");
			System.exit(2);
		}
		Job job = new Job(conf, "Similarity");
		job.setJarByClass(Similarity.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setReducerClass(ReducerClass.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(VectorWritable.class);

		job.setNumReduceTasks(1);
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
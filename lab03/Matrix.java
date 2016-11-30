package lab03;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Matrix {

	public static class TokenizerMapper extends Mapper<Object, Text, Text, Text> {
		private String matrixname = new String(); // matrix name
		private Text index = new Text();
		private String ivalue = new String(); // index i
		private String jvalue = new String(); // index j
		private String realvalue = new String(); // value
		private Text union = new Text(); // value
		private int nvalue = 100; // A is 
		private int mvalue = 100; // B is 

		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {
			String[] arr = value.toString().split("\t");
			matrixname = arr[0];
			ivalue = arr[1];
			jvalue = arr[2];
			realvalue = arr[3];

			if (matrixname.equals("A")) {
				for (int i = 0; i < mvalue; i++) {
					union.set(jvalue + "/" + realvalue);
					index.set(ivalue + "/" + Integer.toString(i));
					context.write(index, union);
				}
			} else {
				for (int i = 0; i < nvalue; i++) {
					union.set(ivalue + "/" + realvalue);
					index.set(Integer.toString(i) + "/" + jvalue);
					context.write(index, union);
				}
			}
		}
	}

	public static class IntSumReducer extends Reducer<Text, Text, Text, Text> {

		private Text result = new Text();

		public void reduce(Text key, Iterable<Text> values,
				Context context) throws IOException, InterruptedException {
			int sum = 0;
			int index;
			int realvalue;
			HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
			
			for (Text val : values) {
				String[] arr = val.toString().split("/");
				index = Integer.parseInt(arr[0]);
				realvalue = Integer.parseInt(arr[1]);
				
				if (!list.containsKey(index)) {
					list.put(index, realvalue);
				} else {
					int temp = list.get(index);
					list.replace(index, temp * realvalue);
				}
			}
			
			Collection<Integer> valuess = list.values();
			Iterator<Integer> itr = valuess.iterator();
			
			while (itr.hasNext()) {
				int va = itr.next();
				sum += va;
			}
			
			result.set(Integer.toString(sum));
			context.write(key, result);
		}
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration(); // job 수행하기 위한 설정 초기화
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
		if (otherArgs.length != 2) {
			System.err.println("Usage: Matrix muptiplication <in> <out>");
			System.exit(2);
		}
		Job job = new Job(conf, "Matrix multiplication"); // job 작성, 따옴표안은 설명을 쓰면됨(상관없음)
		job.setJarByClass(Matrix.class); // job을 수행할 class 선언, 파일명.class,
											// 대소문자주의
		job.setMapperClass(TokenizerMapper.class); // Map class 선언, 위에서 작성한
													// class명

		job.setReducerClass(IntSumReducer.class); // Reduce class 선언
		job.setOutputKeyClass(Text.class); // Output key type 선언
		job.setOutputValueClass(Text.class); // Output value type 선언
		// job.setMapOutputKeyClass(Text.class); // Map은 Output key type이 다르다면
		// 선언
		// job.setMapOutputValueClass(IntWritable.class); // Map은 Output value
		// type이 다르다면 선언
		job.setNumReduceTasks(1); // 동시에 수행되는 reduce개수
		FileInputFormat.addInputPath(job, new Path(otherArgs[0])); // 입력 데이터가 있는
																	// path
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1])); // 결과를 출력할
																		// path
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
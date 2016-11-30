package lab09;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class VectorWritable implements WritableComparable<VectorWritable>
{
	public double[] vec= new double[10]; 
	
	public String toString()
	{
		return getVector();
	}
	
	public String getVector() { 
		return ""+vec[0] + "\t" + vec[1] + "\t" + vec[2] + "\t" + vec[3] + "\t" + vec[4] + "\t" + vec[5] + "\t" + vec[6] + "\t" + vec[7] + "\t" + vec[8] + "\t" + vec[9]; 
	} 

	public void readFields(DataInput arg0) throws IOException {
		vec[0]=arg0.readDouble();
		vec[1]=arg0.readDouble();
		vec[2]=arg0.readDouble();
		vec[3]=arg0.readDouble();
		vec[4]=arg0.readDouble();
		vec[5]=arg0.readDouble();
		vec[6]=arg0.readDouble();
		vec[7]=arg0.readDouble();
		vec[8]=arg0.readDouble();
		vec[9]=arg0.readDouble();
	}

	public void write(DataOutput arg0) throws IOException {
		arg0.writeDouble(vec[0]);
		arg0.writeDouble(vec[1]);
		arg0.writeDouble(vec[2]);
		arg0.writeDouble(vec[3]);
		arg0.writeDouble(vec[4]);
		arg0.writeDouble(vec[5]);
		arg0.writeDouble(vec[6]);
		arg0.writeDouble(vec[7]);
		arg0.writeDouble(vec[8]);
		arg0.writeDouble(vec[9]);
	
	}

	public int compareTo(VectorWritable arg0) {
		for(int i=0 ; i< vec.length ; i++)
		{
			if(vec[i] > arg0.vec[i] )
			{
				return 1;
			}
			else if (vec[i] < arg0.vec[i])
			{
				return -1;
			}
			
		}		return 0;
	}

	
}


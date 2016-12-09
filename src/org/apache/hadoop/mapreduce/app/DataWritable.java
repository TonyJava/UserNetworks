package org.apache.hadoop.mapreduce.app;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
 * 
 *手机流量分析
 */
public class DataWritable implements Writable {

	// upload 
	private int upPackNum;
	private int upPayLoad;
	// download
	private int downPackNum;
	private int downPayLoad;

	public DataWritable() {
		// TODO Auto-generated constructor stub
	}

	public void set(int upPackNum, int upPayLoad, int downPackNum,
			int downPayLoad) {
		this.upPackNum = upPackNum;
		this.upPayLoad = upPayLoad;
		this.downPackNum = downPackNum;
		this.downPayLoad = downPayLoad;
	}

	public int getUpPackNum() {
		return upPackNum;
	}

	public int getUpPayLoad() {
		return upPayLoad;
	}

	public int getDownPackNum() {
		return downPackNum;
	}

	public int getDownPayLoad() {
		return downPayLoad;
	}

	public void write(DataOutput out) throws IOException {
		out.writeInt(upPackNum);
		out.writeInt(upPayLoad);
		out.writeInt(downPackNum);
		out.writeInt(downPayLoad);

	}

	public void readFields(DataInput in) throws IOException {
		this.upPackNum = in.readInt();
		this.upPayLoad = in.readInt();
		this.downPackNum = in.readInt();
		this.downPayLoad = in.readInt();
	}

	@Override
	public String toString() {
		return upPackNum + "\t" + upPayLoad + "\t" + downPackNum + "\t"
				+ downPayLoad + "\t";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + downPackNum;
		result = prime * result + downPayLoad;
		result = prime * result + upPackNum;
		result = prime * result + upPayLoad;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataWritable other = (DataWritable) obj;
		if (downPackNum != other.downPackNum)
			return false;
		if (downPayLoad != other.downPayLoad)
			return false;
		if (upPackNum != other.upPackNum)
			return false;
		if (upPayLoad != other.upPayLoad)
			return false;
		return true;
	}

}

package com.gclasscn.xiaojun.domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class TypedFile implements TypedInput, TypedOutput{
	
	private static final int BUFFER_SIZE = 4096;

	private final String mimeType;
	private final InputStream in;
	private final String filename;


	public TypedFile(String filename, String mimeType, InputStream in) {
		if (filename == null) {
			throw new NullPointerException("filename");
		}
		if (mimeType == null) {
			throw new NullPointerException("mimeType");
		}
		if (in == null) {
			throw new NullPointerException("in");
		}
		this.filename = filename;
		this.mimeType = mimeType;
		this.in = in;
	}

	@Override
	public String mimeType() {
		return mimeType;
	}

	@Override
	public long length() {
		try {
			return (long) in.available();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public String fileName() {
		return filename;
	}

	@Override
	public InputStream in() throws IOException {
		return in;
	}

	@Override
	public void writeTo(OutputStream out) throws IOException {
		byte[] buffer = new byte[BUFFER_SIZE];
		try {
			int read;
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
		} finally {
			in.close();
		}
	}
}

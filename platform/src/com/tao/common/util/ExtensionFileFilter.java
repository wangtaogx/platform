package com.tao.common.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class ExtensionFileFilter  implements FileFilter {  
	  
	private String extension;  
	  
	public ExtensionFileFilter(String extension) {  
	    this.extension = extension;  
	}  
	  
	public File[] getFiles(String srcDir) throws IOException {  
	    return (File[]) FileUtils.listFiles(srcDir).toArray();  
	}  
	  
	public boolean accept(File file) {  
	    if (file.isDirectory()) {  
	        return false;  
	    }  
	      
	    String name = file.getName();  
	    // find the last  
	    int idx = name.lastIndexOf(".");  
	    if (idx == -1) {  
	        return false;  
	    } else if (idx == name.length() - 1) {  
	        return false;  
	    } else {  
	        return this.extension.equals(name.substring(idx + 1));  
	    }  
	}  
  
}  
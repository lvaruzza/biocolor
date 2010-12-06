package com.lifetech.solid.bam;

import java.io.File;

import net.sf.samtools.SAMFileReader;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;
import static java.lang.System.out;

public class TestReadBam {
	private File input;
	
	@Before
	public void configure() {
		input = new File("data/bfast.bam");
	}
	
	@Test
	public void testPrintCS() {
		ReadBam readBam = new ReadBam();
		SAMFileReader reader = new SAMFileReader(input);		
		for (String cs: readBam.colorSeqs(Iterables.limit(reader, 10))) {
			out.println(cs);
		}
	}

}

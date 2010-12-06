package com.lifetech.solid.bam;

import net.sf.samtools.SAMRecord;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class ReadBam {
	public Iterable<String> colorSeqs(Iterable<SAMRecord> records) {
		return Iterables.transform(records, new Function<SAMRecord,String>() {
			public String apply(SAMRecord rec) {
				return rec.getStringAttribute("CS");
			}
		});
	}
}

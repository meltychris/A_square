package com.example.study_path;

import android.app.Activity;
import android.os.Bundle;

public class data extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub

	  
	}
	
	static public String get(String major, int sem) {
	    // TODO Auto-generated method stub
		int size = 2;
		String result = " ";
		for (int i=0; i<size; i++)
			if (major.equals(A[i][0])){
				if (sem == 1)
					result = A[i][1];
				else if (sem == 2)
					result = A[i][2];
				else
					result = A[i][3];
			}
				
		return result;
	}
	
	static String A[][] = {{"COMP","FALL:\nCOMP1004\nELEC1100\nMATH1018\nIELM2200\nHLTH1010\n\nSPRING:\nCOMP1900\nCOMP2012\nCOMP2611\nCOMP2711\nCommon\nLANG1001s","FALL: COMP3031\nCOMP3511\nCOMP3711\nCommon\nCOMP3XXX\n\nSPRING\nCOMP3111\nMATH2011\nMATH2111\nLANG2030A\nCOMP3XXX\nCOMP2900", "FALL:\nCOMP4000\nCOMP4000\nCOMP4000\nCOMP4000\nCOMP4000\n\nSPRING:\nCOMP4000\nCOMP4000\nCOMP4000\nCOMP4000\nCOMP4000\n"}
						,{"IELM","FALL:\nhea\n\nSPRING:\nhea","FALL:\nhea\n\nSPRING:\nhea","FALL:\nhea\n\nSPRING:\nhea"}};

}

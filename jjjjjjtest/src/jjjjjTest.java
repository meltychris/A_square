 
 
import android.test.ActivityInstrumentationTestCase2; 
import android.test.TouchUtils; 
import android.test.suitebuilder.annotation.SmallTest; 
import android.widget.Button; 
import android.widget.EditText; 
import hk.ust.cse.converter.ConverterActivity; 
 
// ActivityInstrumentationTestCase2 provides functional testing of a single activity 
public class jjjjjTest extends ActivityInstrumentationTestCase2<ConverterActivity> { 
 private ConverterActivity mActivity; 
 Button buttonKilos, buttonPounds; 
 EditText textKilos, textPounds; 
//delta - the maximum delta between expected and actual for which both numbers are still considered equal.
private static final double DELTA = 1e-15; // constant for comparing doubles values 

public ConverterActivityTest() { 
super(ConverterActivity.class); 

} 

@Override 
protected void setUp() throws Exception { 
//this method is called every time before any test execution 
super.setUp(); 

mActivity = (ConverterActivity) getActivity(); // get current activity 

// link the objects with the activity objects 
buttonKilos = (Button) mActivity 
.findViewById(hk.ust.cse.converter.R.id.Kilos); 
buttonPounds = (Button) mActivity 
.findViewById(hk.ust.cse.converter.R.id.Pounds); 
textKilos = (EditText) mActivity 
.findViewById(hk.ust.cse.converter.R.id.inputvalueK); 
textPounds = (EditText) mActivity 
.findViewById(hk.ust.cse.converter.R.id.inputvalueP); 
} 


@Override 
protected void tearDown() throws Exception { 
//this method is called every time after any test execution 
// we want to clean the texts 
textKilos.clearComposingText(); 
textPounds.clearComposingText(); 
super.tearDown(); 
} 

@SmallTest // SmallTest: this test doesn't interact with any file system or network. 
public void testView() { // checks if the activity is created 
assertNotNull(getActivity()); 
} 

@SmallTest 
public void testKilosToPounds() { 

/* INTERACTIONS */ 
TouchUtils.tapView(this, textKilos); // tap the EditText textKilos 
sendKeys("1"); // sent the number 1 
TouchUtils.clickView(this, buttonPounds); // click the button buttonPounds 

/*CHECK THE RESULT*/ 
double pounds; 
try { 
pounds = Double.parseDouble(textPounds.getText().toString()); 
} catch (NumberFormatException e) { 
pounds = -1; 
} 

//JUnit Assert equals 

// message expected actual delta for comparing doubles 
assertEquals("1 kilo is 2.20462262 pounds", 2.20462262, pounds, DELTA); 
} 

} 
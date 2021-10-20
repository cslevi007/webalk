package hu.me.iit.webalk.dependency;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceImplTest {

	@Mock
	Dependency dependency;

	@InjectMocks
	ServiceImpl service;

	@Test
	void calculateTest() {
	    //GIVEN

		//WHEN
	    service.calculate();

	    //THEN
	    verify(dependency, times(1)).helpNoParameterNoReturnValue();
	}

	@Test
	void return5Test(){

	    //GIVEN
	    final int FIVE = 5;

	    //WHEN
	    int result = service.returnFive();

	    //THEN
	    assertEquals(FIVE, result);
	}


	@Test
	void dependencyReturnValueIsUsedTest(){

	    //GIVEN
	    final int FIVE = 5;
	    when(dependency.helpNoParameterReturnValue()).thenReturn(FIVE);

	    //WHEN
	    int result = service.callHelpAndUseReturnValue();

	    //THEN
	    verify(dependency, times(1)).helpNoParameterReturnValue();
	    assertEquals(FIVE, result);
	    }
	
	@Test
    // Is the service calls the dependency?
    // Is the parameter of dependency method appropriate?
	void callHelpAndPassParameter5Test() {
    // GIVEN
    final int FIVE = 5;

    // WHEN
    service.callHelpAndPassParameter5();

    // THEN
    ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

    verify(dependency, times(1)).helpWithParameterNoReturnValue(captor.capture());
    assertEquals(FIVE,captor.getValue());
	}
	
	@Test
    void getImportantAbstractTest(){
		//GIVEN
		String testString = "abcdegfhzunbg";
        String expected = "<b>abc...</b>";
        String goal = service.getFirst3Char(testString);
        when(dependency.important(goal)).thenReturn("<b>abc...</b>");

        //WHEN
        String result = service.getImportantAbstract(testString);

        //THEN
        verify(dependency, times(1)).important(goal);
        assertEquals(expected, result);
    }
}

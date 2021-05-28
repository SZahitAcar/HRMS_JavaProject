package zodyrike.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String message) {
		//successDataResult oldugu icin true elle verildi.
		super(data,true, message);
		// TODO Auto-generated constructor stub
	}
	public SuccessDataResult(T data) {
		super(data, true);
	}
	public SuccessDataResult(String message) {
		super(null, true, message);
	}
	
}

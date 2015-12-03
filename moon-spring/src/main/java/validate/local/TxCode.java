package validate.local;

/**
 * 交易代码
 *
 */
public enum TxCode {
	RECHARGE("1000","网银充值"),
	RECHARGE_POS("1001","POS机充值"),
	PUBLIC_RECHARGE("1002","对公充值"),
	AUTHENTICATION_RECHARGE("1003","认证WAP充值");

	private final String code;
	private final String desc;
	private TxCode(String code, String desc){
		this.code = code;
		this.desc = desc;
	}
	
	public static TxCode getTxCode(String code){
		for(TxCode item : TxCode.values()){
			if(item.getCode().equals(code)){
				return item;
			}
		}
		return null;
	}
	
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	
}

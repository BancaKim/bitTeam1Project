package Member;

public class RegularMember extends Member {
	private int overTimeAllowance;
	private String lastGrade;
	private int cert;
	private String jobLevel;
	
	
	public RegularMember() {
		
	}
	
	public int getOverTimeAllowance() {
		return overTimeAllowance;
	}
	public void setOverTimeAllowance(int overTimeAllowance) {
		this.overTimeAllowance = overTimeAllowance;
	}
	public String getLastGrade() {
		return lastGrade;
	}
	public void setLastGrade(String lastGrade) {
		this.lastGrade = lastGrade;
	}
	public int getCert() {
		return cert;
	}
	public void setCert(int cert) {
		this.cert = cert;
	}
	public String getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	
	
}

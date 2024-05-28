package com.app.entities;

public class Candidate {
	private int candidateId;
	private String candidateName;
	private String partyname;
	private int votes;
	private int sum;
	
	//constr
	public Candidate()
	{
		
	}
	
	public Candidate(int candidateId, String candidateName, String partyname, int votes) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.partyname = partyname;
		this.votes = votes;
	}
	
	public Candidate(String partyname, int sum) {
		super();
		this.partyname = partyname;
		this.sum = sum;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getPartyname() {
		return partyname;
	}

	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", partyname=" + partyname
				+ ", votes=" + votes + "]";
	}
	
}

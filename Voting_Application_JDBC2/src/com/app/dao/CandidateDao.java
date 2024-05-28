package com.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.app.entities.Candidate;

public interface CandidateDao {
	//get all candidate details
	List<Candidate> getCandidates() throws SQLException;
	//increase candidate votes
	String voteCandidate(int candidateId) throws SQLException;
	//candidates having max votes
	List<Candidate> maxVotedCandidates() throws SQLException;
	//get party votes 
	List<Candidate> noOfVotes() throws SQLException;
	

}

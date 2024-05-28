package com.app.dao;

import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Candidate;

public class CandidateDaoImpl implements CandidateDao{
	
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4;
	
	public CandidateDaoImpl() throws SQLException
	{
		cn=openConnection();
		//get all candidates
		pst1=cn.prepareStatement("select * from candidates");
		//increase candidate votes
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		//get first 2 candidates having max votes
		pst3=cn.prepareStatement("select * from candidates order by votes desc limit 2");
		//get no of votes acc to party
		pst4=cn.prepareStatement("select party,sum(votes) total_votes from candidates group by party");
	}

	@Override
	public List<Candidate> getCandidates() throws SQLException {
		List<Candidate> list=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				list.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
		} 
		return list;
	}
	
	@Override
	public String voteCandidate(int candidateId) throws SQLException {
		//set IN params
		pst2.setInt(1, candidateId);
		int row=pst2.executeUpdate();
		if(row==1)
		{
			return "your vote has been casted";
		}
		
		return "vote not casted";
	}

	//get first 2 candidates having max votes
	@Override
	public List<Candidate> maxVotedCandidates() throws SQLException {
		List<Candidate> list=new ArrayList<>();
		try(ResultSet rst=pst3.executeQuery())
		{
			while(rst.next()) 
			{
				list.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
			}
		}
		return list;
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
		if(pst3!=null)
			pst3.close();
		if(pst4!=null)
			pst4.close();
	}

	@Override
	public List<Candidate> noOfVotes() throws SQLException {
		List<Candidate> list=new ArrayList<>();
		try(ResultSet rst=pst4.executeQuery())
		{
			while(rst.next())
				list.add(new Candidate(rst.getString(1),rst.getInt(2)));
		}
		
		return list;
	}

	

	
}

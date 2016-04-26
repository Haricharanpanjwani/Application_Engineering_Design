package com.spring.forensic.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.ngram.NGramFilterFactory;
import org.apache.lucene.analysis.standard.StandardFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

@AnalyzerDef(name = "ngram",
tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class ),
filters = {
  @TokenFilterDef(factory = StandardFilterFactory.class),
  @TokenFilterDef(factory = LowerCaseFilterFactory.class),
  @TokenFilterDef(factory = StopFilterFactory.class),
  @TokenFilterDef(factory = NGramFilterFactory.class,
    params = { 
      @Parameter(name = "minGramSize", value = "1"),
      @Parameter(name = "maxGramSize", value = "10") } )
}
)

@Entity
@Indexed
@PrimaryKeyJoinColumn(name="personID")
public class UserAccounts extends Person {
	
	//@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name ="userName")
	private String userName;		

	@Column(name ="password")
	private String password;
	
	@Column(name ="role")
	private String role;
	
	@OneToOne
	@JoinColumn(name = "enterpriseId")
	private Enterprises enterprise;
	
	@Field(index = Index.YES, analyzer=@Analyzer(definition="ngram"), store = Store.NO)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Enterprises getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprises enterprise) {
		this.enterprise = enterprise;
	}	
	
	@Override
	public String toString() {
		return this.userName;
	}
}

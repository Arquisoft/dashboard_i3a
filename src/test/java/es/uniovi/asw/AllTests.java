package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uniovi.asw.domain.CommentTest;
import es.uniovi.asw.domain.ProposalTest;
import es.uniovi.asw.domain.UserTest;
import es.uniovi.asw.domain.VoteCommentTest;
import es.uniovi.asw.domain.VoteProposalTest;
import es.uniovi.asw.util.AgeCalculatorTest;

@RunWith(Suite.class)
@SuiteClasses({ UserTest.class, ProposalTest.class, VoteCommentTest.class, VoteProposalTest.class, CommentTest.class,
		AgeCalculatorTest.class })
public class AllTests {

}

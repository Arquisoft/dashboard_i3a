package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uniovi.asw.domain.CommentTest;
import es.uniovi.asw.domain.ProposalTest;
import es.uniovi.asw.domain.UserTest;
import es.uniovi.asw.domain.VoteCommentTest;
import es.uniovi.asw.domain.VoteProposalTest;
import es.uniovi.asw.dto.ProposalDtoTest;
import es.uniovi.asw.dto.UserDtoTest;
import es.uniovi.asw.dto.UserLoginTest;
import es.uniovi.asw.logicinfo.VotesInfoGeneroTest;
import es.uniovi.asw.logicinfo.VotesInfoRangoEdadTest;
import es.uniovi.asw.logicinfo.VotesInformationTest;
import es.uniovi.asw.repository.CommentRepositoryTest;
import es.uniovi.asw.repository.ProposalRepositoryTest;
import es.uniovi.asw.repository.UserRepositoryTest;
import es.uniovi.asw.util.AgeCalculatorTest;

@RunWith(Suite.class)
@SuiteClasses({ UserTest.class, ProposalTest.class, VoteCommentTest.class, VoteProposalTest.class, CommentTest.class,
		AgeCalculatorTest.class, UserLoginTest.class, UserDtoTest.class, ProposalDtoTest.class,
		VotesInfoGeneroTest.class, VotesInfoRangoEdadTest.class, VotesInformationTest.class,
		CommentRepositoryTest.class, ProposalRepositoryTest.class, UserRepositoryTest.class })
public class AllTests {

}

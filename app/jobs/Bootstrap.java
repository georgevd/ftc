package jobs;

import controllers.Application;
import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import uk.ac.ebi.brain.core.Brain;
import uk.ac.ebi.brain.error.BrainException;
import uk.ac.ebi.brain.error.ExistingEntityException;
import uk.ac.ebi.brain.error.NewOntologyException;

@OnApplicationStart
public class Bootstrap extends Job {

	public void doJob() throws BrainException {
		Logger.info("Setting the brain spell checker...");
		Application.spellChecker = new Brain("http://www.ebi.ac.uk/ftc/", "http://www.ebi.ac.uk/ftc/ftc-kb-full.owl", 1);
		Application.spellChecker.learn("data/ftc-kb-full.owl");
		Logger.info("Spell Checker loaded!");
	}

}
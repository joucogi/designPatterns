package usantatecla.ChainOfResponsibility.chainOfResponsibilityFine;

public class EducationAffairsViceDean extends ClaimSolver {

	public EducationAffairsViceDean(ClaimSolver claimSolver) {
		super(claimSolver);
		this.name = this.getClass().getSimpleName().substring(0, 1).toLowerCase()
				+ this.getClass().getSimpleName().substring(1);
	}

	@Override
	public void handleComplainAboutExam() {
		printer.printMessageLevel1("Received complain about exam (" + this.name + ")");

		if (this.generateRandomSolvingSkill() == SolvingSkill.TRUE.ordinal()) {
			printer.printMessageLevel2("SOLVED (" + this.name + ") \n");
		} else if (this.next != null) {
			printer.printMessageLevel2("Sent to next");
			next.handleComplainAboutExam();
		}
	}


	@Override
	public void handleComplainAboutDepartmentRule() {
		printer.printMessageLevel1("Received complain about department rule (" + this.name + ")");
		if (this.generateRandomSolvingSkill() == SolvingSkill.TRUE.ordinal()) {
			printer.printMessageLevel2("SOLVED (" + this.name + ") \n");
		} else if (this.next != null) {
			printer.printMessageLevel2("Sent to next");
			next.handleComplainAboutDepartmentRule();
		}
	}
}

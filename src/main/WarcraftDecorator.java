package main;

public abstract class WarcraftDecorator extends AbstractWarcraft{

    Warcraft warcraft;

    public WarcraftDecorator(Warcraft warcraft) {
        this.warcraft = warcraft;
    }
}

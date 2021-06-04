package ru.job4j.stream;

public class PC {
    private String name;
    private String processor;
    private String ram;
    private String graphicsCard;
    private int oSystem;
    private boolean activated;
    private String display;

    static class Builder {
        private String name;
        private String processor;
        private String ram;
        private String graphicsCard;
        private int oSystem;
        private boolean activated;
        private String display;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        Builder buildRam(String ram) {
            this.ram = ram;
            return this;
        }

        Builder buildGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        Builder buildOSystem(int oSystem) {
            this.oSystem = oSystem;
            return this;
        }

        Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        Builder buildDisplay(String display) {
            this.display = display;
            return this;
        }

        PC build() {
            PC pc = new PC();
            pc.name = name;
            pc.processor = processor;
            pc.ram = ram;
            pc.graphicsCard = graphicsCard;
            pc.oSystem = oSystem;
            pc.activated = activated;
            pc.display = display;
            return pc;
        }
    }

    @Override
    public String toString() {
        return "PC{"
                + "name='" + name + '\''
                + ", processor='" + processor + '\''
                + ", ram='" + ram + '\''
                + ", graphicsCard='" + graphicsCard + '\''
                + ", oSystem=" + oSystem
                + ", activated=" + activated
                + ", display='" + display + '\''
                + '}';
    }

    public static void main(String[] args) {
        PC pc = new Builder().buildName("user-PS")
                .buildProcessor("AMD Ryzen 5")
                .buildRam("HyperX Fury 32GB")
                .buildGraphicsCard("RTX 3080")
                .buildOSystem(64)
                .buildActivated(true)
                .buildDisplay("4K")
                .build();
        System.out.println(pc);
    }
}
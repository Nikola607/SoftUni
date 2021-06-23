package ExamPreparation.CounterStriker.models.players;

import ExamPreparation.CounterStriker.models.guns.Gun;

import static ExamPreparation.CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armour;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armour, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmour(armour);
        this.setGun(gun);
        this.setAlive(true);
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    public void setArmour(int armour) {
        if (armour < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armour = armour;
    }

    public void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armour;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (getArmor() > 0) {
            setArmour(getArmor() - points);
        }

        if (getHealth() > 0 && getArmor() <= 0) {
           setHealth(getHealth() - points);
        }

        if (getHealth() <= 0) {
            setAlive(false);
        }
    }

    @Override
    public String toString(){
        return String.format("%s: %s\n" +
                "--Health: %s\n" +
        "--Armor: %s\n" +
        "--Gun: %s", getClass().getSimpleName(), getUsername(), getHealth(), getArmor(), getGun().getName());
    }
}

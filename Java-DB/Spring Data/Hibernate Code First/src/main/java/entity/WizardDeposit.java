package entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "wizard_deposit")
public class WizardDeposit extends BaseEntity {
    private String first_name;
    private String last_name;
    private String notes;
    private int age;
    private String magic_wand_creator;
    private Short magic_wand_size;
    private String deposit_group;
    private LocalDateTime deposit_start_date;
    private BigDecimal deposit_amount;
    private Float deposit_interest;
    private Float deposit_charge;
    private LocalDateTime deposit_expiration_date;
    private Boolean is_deposit_expired;

    public WizardDeposit() {
    }

    @Column(length = 50)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(nullable = false, length = 60)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Column(length = 1000, columnDefinition = "Text")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(length = 100)
    public String getMagic_wand_creator() {
        return magic_wand_creator;
    }

    public void setMagic_wand_creator(String magic_wand_creator) {
        this.magic_wand_creator = magic_wand_creator;
    }

    @Column(nullable = false)
    public Short getMagic_wand_size() {
        return magic_wand_size;
    }

    public void setMagic_wand_size(Short magic_wand_size) {
        this.magic_wand_size = magic_wand_size;
    }

    @Column(length = 20)
    public String getDeposit_group() {
        return deposit_group;
    }

    public void setDeposit_group(String deposit_group) {
        this.deposit_group = deposit_group;
    }

    @Column()
    public LocalDateTime getDeposit_start_date() {
        return deposit_start_date;
    }

    public void setDeposit_start_date(LocalDateTime deposit_start_date) {
        this.deposit_start_date = deposit_start_date;
    }

    @Column(precision = 10, scale = 3)
    public BigDecimal getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(BigDecimal deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    @Column()
    public Float getDeposit_interest() {
        return deposit_interest;
    }

    public void setDeposit_interest(Float deposit_interest) {
        this.deposit_interest = deposit_interest;
    }

    @Column()
    public Float getDeposit_charge() {
        return deposit_charge;
    }

    public void setDeposit_charge(Float deposit_charge) {
        this.deposit_charge = deposit_charge;
    }

    @Column()
    public LocalDateTime getDeposit_expiration_date() {
        return deposit_expiration_date;
    }

    public void setDeposit_expiration_date(LocalDateTime deposit_expiration_date) {
        this.deposit_expiration_date = deposit_expiration_date;
    }

    @Column()
    public Boolean getIs_deposit_expired() {
        return is_deposit_expired;
    }

    public void setIs_deposit_expired(Boolean is_deposit_expired) {
        this.is_deposit_expired = is_deposit_expired;
    }
}

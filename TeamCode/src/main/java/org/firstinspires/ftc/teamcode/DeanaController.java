package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DeanaController {

    private final DeanaMotor motor_lf;
    private final DeanaMotor motor_lb;
    private final DeanaMotor motor_rf;
    private final DeanaMotor motor_rb;
    public final DeanaArm arm_l;
    public final DeanaArm arm_r;
    public final DeanaServo cup_r;
    public final DeanaServo cup_l;
    private final DeanaIntake intake;
    private final DeanaMotor carousel;

    public boolean arm_moving;

    public DeanaController(HardwareMap hardwareMap) {
        // Init Hardware
        motor_lf = new DeanaMotor(hardwareMap.dcMotor.get("motor_lf"), false);
        motor_lb = new DeanaMotor(hardwareMap.dcMotor.get("motor_lb"), false);
        motor_rf = new DeanaMotor(hardwareMap.dcMotor.get("motor_rf"), true);
        motor_rb = new DeanaMotor(hardwareMap.dcMotor.get("motor_rb"), true);
        arm_l = new DeanaArm(hardwareMap.dcMotor.get("lift_l"), false);
        arm_r = new DeanaArm(hardwareMap.dcMotor.get("lift_r"), true);
        cup_l = new DeanaServo(hardwareMap.servo.get("cup_l"), true);
        cup_r = new DeanaServo(hardwareMap.servo.get("cup_r"), false);
        intake = new DeanaIntake(hardwareMap.crservo.get("intake"));
        carousel = new DeanaMotor(hardwareMap.dcMotor.get("carousel"), false);

        arm_moving = false;
    }

    public void move_forward(double power) {
        motor_lf.run(power);
        motor_lb.run(power);
        motor_rf.run(power);
        motor_rb.run(power);
    }

    public void rotate(double power) {
        motor_lf.run(power);
        motor_lb.run(power);
        motor_rf.run(-power);
        motor_rb.run(-power);
    }

    public void extend_arm() {
        arm_l.extend();
        arm_r.extend();

        arm_moving = true;
    }

    public void spin_cup(double amount) {
        cup_l.spin(amount);
        cup_r.spin(amount);
    }

    public void reset_cup() {
        cup_l.reset();
        cup_r.reset();
    }

    public void run_intake(double power) {
        intake.run(power);
    }

    public void run_arm() {
        arm_l.run();
        arm_r.run();

        arm_moving = arm_l.arm_moving || arm_r.arm_moving;
    }

    public void retract_arm() {
        arm_l.retract();
        arm_r.retract();

        arm_moving = true;
    }

    public void starting_position() {
        arm_l.set_position(1250);
        arm_r.set_position(1250);

        arm_moving = true;
    }

    public void strafe(double power) {
        motor_lf.run(-power);
        motor_lb.run(power);
        motor_rf.run(power);
        motor_rb.run(-power);
    }

    public void run_carousel(double power) {
        carousel.run(power);
    }
}

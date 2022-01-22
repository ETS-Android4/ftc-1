package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DeanaController {

    private DeanaMotor motor_lf;
    private DeanaMotor motor_lb;
    private DeanaMotor motor_rf;
    private DeanaMotor motor_rb;
    public DeanaArm arm_l;
    public DeanaArm arm_r;

    public DeanaController(HardwareMap hardwareMap) {
        // Init Hardware
        motor_lf = new DeanaMotor(hardwareMap.dcMotor.get("motor_lf"), false);
        motor_lb = new DeanaMotor(hardwareMap.dcMotor.get("motor_lb"), false);
        motor_rf = new DeanaMotor(hardwareMap.dcMotor.get("motor_rf"), true);
        motor_rb = new DeanaMotor(hardwareMap.dcMotor.get("motor_rb"), true);
        arm_l = new DeanaArm(hardwareMap.dcMotor.get("lift_l"));
        arm_r = new DeanaArm(hardwareMap.dcMotor.get("lift_r"));
    }

    public void move_forward(double power) {
        motor_lf.run(power);
        motor_lb.run(power);
        motor_rf.run(power);
        motor_rb.run(power);
        arm_r.run();
        arm_l.run();
    }

    public void extend_arm() {
        arm_l.extend();
        arm_r.extend();
    }

    public void retract_arm() {
        arm_l.retract();
        arm_r.retract();
    }

}

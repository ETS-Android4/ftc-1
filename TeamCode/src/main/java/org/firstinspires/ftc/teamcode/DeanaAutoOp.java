package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Deana Blue Carousel", group = "Deana")
public class DeanaAutoOp extends LinearOpMode {

    DcMotor rf;
    DcMotor lf;
    DcMotor rb;
    DcMotor lb;
    DcMotor arm_l;
    DcMotor arm_r;

    DcMotor[] arms = new DcMotor[2];

    final double speed = 0.5;

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        rf = hardwareMap.dcMotor.get("motor_rf");
        lf = hardwareMap.dcMotor.get("motor_lf");
        rb = hardwareMap.dcMotor.get("motor_rb");
        lb = hardwareMap.dcMotor.get("motor_lb");
        arm_l = hardwareMap.dcMotor.get("lift_l");
        arm_r = hardwareMap.dcMotor.get("lift_r");

        lf.setDirection(DcMotor.Direction.FORWARD);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.REVERSE);
        arm_l.setDirection(DcMotor.Direction.FORWARD);
        arm_r.setDirection(DcMotor.Direction.REVERSE);

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lf.setTargetPosition(0);
        rf.setTargetPosition(0);
        lb.setTargetPosition(0);
        rb.setTargetPosition(0);

        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        arms[0] = arm_l;
        arms[1] = arm_r;

        while(opModeIsActive()) {

            run_motors(arms, 100);

//            controller.starting_position();
//            while(controller.arm_moving) controller.run_arm();
//
//            controller.move_forward(1);
//            sleep(475);
//            controller.move_forward(0);
//            standard_pause();
//            controller.rotate(1);
//            sleep(400);
//            controller.rotate(0);
//            standard_pause();
//            controller.move_forward(1);
//            sleep(350);
//            controller.move_forward(0);
//
//            controller.retract_arm();
//            while(controller.arm_moving) controller.run_arm();
//
//            sleep(1000);


            break;
        }
    }

    public void run_motor(DcMotor motor, int position) {
        motor.setTargetPosition(position);
        run_until_done(motor);
    }

    public void run_motors(DcMotor motors[], int position) {
        for (DcMotor motor : motors) {
            motor.setTargetPosition(position);
        }
        run_until_done(motors);
    }

    public void run_until_done(DcMotor motor) {
        motor.setPower(speed);
        while (motor.getCurrentPosition() != motor.getTargetPosition()) {}
        motor.setPower(0);
        return;
    }

    public void run_until_done(DcMotor motors[]) {
        for (DcMotor motor : motors) {
            motor.setPower(speed);
        }
        for (DcMotor motor : motors) {
            while (motor.getCurrentPosition() != motor.getTargetPosition()) {
                telemetry.addData("Position", motor.getCurrentPosition());
            }
        }
        for (DcMotor motor : motors) {
            motor.setPower(0);
        }
        return;
    }
}

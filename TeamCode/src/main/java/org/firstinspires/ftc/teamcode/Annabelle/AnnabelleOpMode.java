package org.firstinspires.ftc.teamcode.Annabelle;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name="Gamepad Drive", group="Experimenting")
public class AnnabelleOpMode extends OpMode {

    AnnabelleDriveController driveController;

    double leftWheelPower;
    double rightWheelPower;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

        // Setup drive controller
        driveController = new AnnabelleDriveController(
                hardwareMap.dcMotor.get("left_front_motor"),
                hardwareMap.dcMotor.get("left_back_motor"),
                hardwareMap.dcMotor.get("right_front_motor"),
                hardwareMap.dcMotor.get("right_back_motor")
        );
        driveController.setPower(0);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        leftWheelPower = gamepad1.left_stick_y;
        rightWheelPower = gamepad1.right_stick_y;

        telemetry.addData("test", AnnabelleDriveController.ALL | AnnabelleDriveController.LEFTFRONT);

        driveController.setPower(leftWheelPower, AnnabelleDriveController.ALL);
        driveController.step();
    }

}

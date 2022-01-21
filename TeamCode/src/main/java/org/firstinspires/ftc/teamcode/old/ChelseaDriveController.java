package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ChelseaDriveController extends FourWheelDriveController {

    double moveX;
    double moveY;

    static final short ControllerMap[][][] = {
        {
            {
                0, 1, 1, 0
            },
            {
                -1, 1, 1, -1
            },
            {
                -1, 0, 0, -1
            }
        },
        {
            {
                    1, 1, 1, 1
            },
            {
                    0, 0, 0, 0
            },
            {
                    -1, -1, -1, -1
            },
        },
        {
            {
                    1, 0, 0, 1
            },
            {
                    1, -1, -1, 1
            },
            {
                    0, -1, -1, 0
            }
        }
    };

    public ChelseaDriveController(DcMotor lfm, DcMotor lbm, DcMotor rfm, DcMotor rbm, boolean invert) {
        super(lfm, lbm, rfm, rbm, invert);

        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setX(double x) {
        moveX = x;
    }
    public void setY(double y) {
        moveY = y;
    }

    public void setRotation(double rot) {
        rotation = rot / 2;
    }

    public void step(Telemetry telemetry) {
        double theta = Math.atan(moveY / moveX) + (moveX < 0 ? Math.PI : 0);
        double x = Math.cos(theta);
        double y = -Math.sin(theta);

        telemetry.addData("X", x);
        telemetry.addData("Y", y);
        telemetry.addData("Theta", (theta * 180) / Math.PI);


        short[] modMatrix = ControllerMap[(int) (Math.round(x) + 1)][(int) (Math.round(y) + 1)];

        lfPower = forwardPower * modMatrix[0];
        lbPower = forwardPower * modMatrix[1];
        rfPower = forwardPower * modMatrix[2];
        rbPower = forwardPower * modMatrix[3];

        telemetry.addData("Left Front Power", lfPower);
        telemetry.addData("Left Back Power", lbPower);
        telemetry.addData("Right Front Power", rfPower);
        telemetry.addData("Right Back Power", rbPower);

        super.step();
    }
}

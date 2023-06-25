package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbCoordinates {

    @JsonAlias("pfx_x")
    private String pfx_x;

    @JsonAlias("pfx_z")
    private String pfx_z;

    @JsonAlias("px")
    private String px;

    @JsonAlias("pz")
    private String pz;

    @JsonAlias("vy0")
    private String vy0;

    @JsonAlias("vz0")
    private String vz0;

    @JsonAlias("vx0")
    private String vx0;

    @JsonAlias("z0")
    private String z0;

    @JsonAlias("ax")
    private String ax;

    @JsonAlias("y0")
    private String y0;

    @JsonAlias("ay")
    private String ay;

    @JsonAlias("x0")
    private String x0;

    @JsonAlias("az")
    private String az;

    @JsonAlias("y")
    private String y;

    @JsonAlias("x")
    private String x;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getPfx_x() {
        return pfx_x;
    }

    public void setPfx_x(String pfx_x) {
        this.pfx_x = pfx_x;
    }

    public String getPfx_z() {
        return pfx_z;
    }

    public void setPfx_z(String pfx_z) {
        this.pfx_z = pfx_z;
    }

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }

    public String getPz() {
        return pz;
    }

    public void setPz(String pz) {
        this.pz = pz;
    }

    public String getVy0() {
        return vy0;
    }

    public void setVy0(String vy0) {
        this.vy0 = vy0;
    }

    public String getVz0() {
        return vz0;
    }

    public void setVz0(String vz0) {
        this.vz0 = vz0;
    }

    public String getVx0() {
        return vx0;
    }

    public void setVx0(String vx0) {
        this.vx0 = vx0;
    }

    public String getZ0() {
        return z0;
    }

    public void setZ0(String z0) {
        this.z0 = z0;
    }

    public String getAx() {
        return ax;
    }

    public void setAx(String ax) {
        this.ax = ax;
    }

    public String getY0() {
        return y0;
    }

    public void setY0(String y0) {
        this.y0 = y0;
    }

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public String getX0() {
        return x0;
    }

    public void setX0(String x0) {
        this.x0 = x0;
    }

    public String getAz() {
        return az;
    }

    public void setAz(String az) {
        this.az = az;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}

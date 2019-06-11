package com.lssjzmn.kilin.boost.entity;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * Created by guimu-work on 2018/6/11.
 */
public class SimulationMapPreference implements Serializable {

    public static final String TAG_K_GM_PROPERTY = "gm_property";
    public static final String TAG_V_AIRPORTAREA = "airportArea";
    public static final String TAG_V_RUNWAY = "runway";
    public static final String TAG_V_TAXIWAY = "taxiway";
    public static final String TAG_V_TERMINAL = "terminal";
    public static final String TAG_V_GRASS = "grass";
    public static final String TAG_V_PARKINGAPRON = "parkingApron";
    public static final String TAG_V_NORMALROAD = "normalRoad";
    public static final String TAG_V_NORMALBUILDING = "normalBuilding";
    public static final String TAG_V_BLOCK = "block";

    public static final String TAG_K_NAME = "name";

    private Color baseColor = Color.DARKGRAY;

    private double borderLineWidth = 2.0;
    private Color borderColor = new Color(164f / 256f, 175f / 256f, 196f / 256f, 1f);

    private Color runwayColor = new Color(187f / 256f, 187f / 256f, 204f / 256f, 1f);

    private double taxiwayWidth = 2.0;
    private Color taxiwayColor = Color.ROYALBLUE;

    private double blockWidth = 0.4;
    private Color blockColor = runwayColor;

    private double normalRoadWidth = 2.0;
    private Color normalRoadColor = new Color(156f / 256f, 100f / 256f, 182f / 256f, 1f);

    private Color normalBuildingColor = new Color(256f / 256f, 256f / 256f, 256f / 256f, 1f);

    private Color terminalColor = new Color(43f / 256f, 47f / 256f, 59f / 256f, 1f);

    private Color apronColor = new Color(57f / 256f, 62f / 256f, 81f / 256f, 1f);

    private Color airportAreaColor = new Color(57f / 256f, 62f / 256f, 81f / 256f, 1f);

    private Color grassColor = new Color(72f / 256f, 88f / 256f, 99f / 256f, 1f);

    public Color getBaseColor() {
        return baseColor;
    }

    public void setBaseColor(Color baseColor) {
        this.baseColor = baseColor;
    }

    public double getBorderLineWidth() {
        return borderLineWidth;
    }

    public void setBorderLineWidth(double borderLineWidth) {
        this.borderLineWidth = borderLineWidth;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Color getRunwayColor() {
        return runwayColor;
    }

    public void setRunwayColor(Color runwayColor) {
        this.runwayColor = runwayColor;
    }

    public double getTaxiwayWidth() {
        return taxiwayWidth;
    }

    public void setTaxiwayWidth(double taxiwayWidth) {
        this.taxiwayWidth = taxiwayWidth;
    }

    public Color getTaxiwayColor() {
        return taxiwayColor;
    }

    public void setTaxiwayColor(Color taxiwayColor) {
        this.taxiwayColor = taxiwayColor;
    }

    public double getNormalRoadWidth() {
        return normalRoadWidth;
    }

    public void setNormalRoadWidth(double normalRoadWidth) {
        this.normalRoadWidth = normalRoadWidth;
    }

    public Color getNormalRoadColor() {
        return normalRoadColor;
    }

    public void setNormalRoadColor(Color normalRoadColor) {
        this.normalRoadColor = normalRoadColor;
    }

    public Color getTerminalColor() {
        return terminalColor;
    }

    public void setTerminalColor(Color terminalColor) {
        this.terminalColor = terminalColor;
    }

    public Color getApronColor() {
        return apronColor;
    }

    public void setApronColor(Color apronColor) {
        this.apronColor = apronColor;
    }

    public Color getAirportAreaColor() {
        return airportAreaColor;
    }

    public void setAirportAreaColor(Color airportAreaColor) {
        this.airportAreaColor = airportAreaColor;
    }

    public Color getGrassColor() {
        return grassColor;
    }

    public void setGrassColor(Color grassColor) {
        this.grassColor = grassColor;
    }

    public Color getBlockColor() {
        return blockColor;
    }

    public void setBlockColor(Color blockColor) {
        this.blockColor = blockColor;
    }

    public double getBlockWidth() {
        return blockWidth;
    }

    public void setBlockWidth(double blockWidth) {
        this.blockWidth = blockWidth;
    }
}

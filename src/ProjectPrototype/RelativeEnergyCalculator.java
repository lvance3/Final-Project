package ProjectPrototype;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RelativeEnergyCalculator 
{
	private static Map<String, Map<String, Integer>> scoringMap = new HashMap<>();

    public static void main(String[] args) 
    {
        //score map for energy values relating to residue proximity
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("ALA", -140);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("ARG", 268);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("ALA", 268);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("ASN", 105);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("ALA", 105);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("ASP", 217);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("ALA", 217);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("CYS", 330);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("ALA", 330);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("GLN", 27);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("ALA", 27);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("GLU", 122);
        scoringMap.put("GLU", new HashMap<>()); scoringMap.get("GLU").put("ALA", 122);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("GLY", 11);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("ALA", 11);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("HIS", 58);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("ALA", 58);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("ILE", -114);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("ALA", -114);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("LEU", -182);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("ALA", -182);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("LYS", 123);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("ALA", 123);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("MET", -74);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("ALA", -74);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("PHE", -65);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("ALA", -65);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("PRO", 174);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("ALA", 174);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("SER", 169);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("ALA", 169);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("THR", 58);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("ALA", 58);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("TRP", 51);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("ALA", 51);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("TYR", 53);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("ALA", 53);
        scoringMap.put("ALA", new HashMap<>()); scoringMap.get("ALA").put("VAL", -105);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("ALA", -105);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("ARG", -18);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("ASN", -85);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("ARG", -85);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("ASP", -616);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("ARG", -616);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("CYS", 67);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("ARG", 67);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("GLN", -60);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("ARG", -60);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("GLU", -564);
        scoringMap.put("GLU", new HashMap<>()); scoringMap.get("GLU").put("ARG", -564);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("GLY", -80);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("ARG", -80);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("HIS", -263);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("ARG", -263);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("ILE", 110);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("ARG", 110);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("LEU", 263);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("ARG", 263);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("LYS", 310);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("ARG", 310);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("MET", 304);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("ARG", 304);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("PHE", 62);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("ARG", 62);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("PRO", -33);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("ARG", -33);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("SER", -80);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("ARG", -80);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("THR", 60);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("ARG", 60);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("TRP", -150);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("ARG", -150);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("TYR", -132);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("ARG", -132);
        scoringMap.put("ARG", new HashMap<>()); scoringMap.get("ARG").put("VAL", 171);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("ARG", 171);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("ASN", -435);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("ASP", -417);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("ASN", -417);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("CYS", 106);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("ASN", 106);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("GLN", -200);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("ASN", -200);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("GLU", -136);
        scoringMap.put("GLU", new HashMap<>()); scoringMap.get("GLU").put("ASN", -136);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("GLY", -103);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("ASN", -103);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("HIS", 61);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("ASN", 61);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("ILE", 351);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("ASN", 351);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("LEU", 358);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("ASN", 358);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("LYS", -201);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("ASN", -210);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("MET", 314);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("ASN", 314);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("PHE", 201);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("ASN", 201);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("PRO", -212);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("ASN", -212);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("SER", -223);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("ASN", -223);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("THR", -231);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("ASN", -231);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("TRP", -18);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("ASN", -18);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("TYR", 53);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("ASN", 53);
        scoringMap.put("ASN", new HashMap<>()); scoringMap.get("ASN").put("VAL", 298);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("ASN", 298);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("ASP", 17);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("CYS", 278);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("ASP", 278);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASN").put("GLN", 67);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("ASP", 67);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("GLU", 140);
        scoringMap.put("GLU", new HashMap<>()); scoringMap.get("GLU").put("ASP", 140);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("GLY", -267);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("ASP", -267);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("HIS", -454);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("ASP", -454);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("ILE", 318);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("ASP", 318);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("LEU", 370);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("ASP", 370);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("LYS", -564);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("ASP", -564);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("MET", 211);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("ASP", 211);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("PHE", 284);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("ASP", 284);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("PRO", -28);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("ASP", -28);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("SER", -299);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("ASP", -299);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("THR", -203);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("ASP", -203);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("TRP", 104);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("ASP", 104);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("TYR", 268);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("ASP", 268);
        scoringMap.put("ASP", new HashMap<>()); scoringMap.get("ASP").put("VAL", 431);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("ASP", 431);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("CYS", -1923);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("GLN", 191);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("CYS", 191);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("GLU", 122);
        scoringMap.put("GLU", new HashMap<>()); scoringMap.get("GLU").put("CYS", 122);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("GLY", 88);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("CYS", 88);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("HIS", 190);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("CYS", 190);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("ILE", 154);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("CYS", 154);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("LEU", 238);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("CYS", 238);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("LYS", 246);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("CYS", 246);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("MET", 50);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("CYS", 50);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("PHE", 34);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("CYS", 34);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("PRO", 105);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("CYS", 105);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("SER", 7);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("CYS", 7);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("THR", 372);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("CYS", 372);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("TRP", 52);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("CYS", 52);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("TYR", 62);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("CYS", 62);
        scoringMap.put("CYS", new HashMap<>()); scoringMap.get("CYS").put("VAL", 196);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("CYS", 196);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("GLN", -115);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("GLU", 10);
        scoringMap.put("GLU", new HashMap<>()); scoringMap.get("GLU").put("GLN", 10);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("GLY", -72);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("GLN", -72);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("HIS", 272);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("GLN", 272);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("ILE", 243);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("GLN", 243);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("LEU", 25);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("GLN", 25);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("LYS", -184);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("GLN", -184);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("MET", 32);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("GLN", 32);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("PHE", 72);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("GLN", 72);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("PRO", -81);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("GLN", -81);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("SER", -163);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("GLN", -163);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("THR", -151);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("GLN", -151);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("TRP", -12);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("GLN", -12);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("TYR", -90);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("GLN", -90);
        scoringMap.put("GLN", new HashMap<>()); scoringMap.get("GLN").put("VAL", 180);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("GLN", 180);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("GLY", -288);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("HIS", 74);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("GLY", 74);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("ILE", 179);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("GLY", 179);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("LEU", 237);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("GLY", 237);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("LYS", 95);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("GLY", 95);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("MET", 13);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("GLY", 13);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("PHE", 114);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("GLY", 114);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("PRO", -73);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("GLY", -73);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("SER", -186);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("GLY", -186);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("THR", -73);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("GLY", -73);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("TRP", -69);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("GLY", -69);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("TYR", 58);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("GLY", 58);
        scoringMap.put("GLY", new HashMap<>()); scoringMap.get("GLY").put("VAL", 202);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("GLY", 202);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("HIS", -448);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("ILE", 294);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("HIS", 294);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("LEU", 200);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("HIS", 200);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("LYS", 54);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("HIS", 54);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("MET", -7);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("HIS", -7);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("PHE", 158);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("HIS", 158);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("PRO", -65);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("HIS", -65);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("SER", -133);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("HIS", -133);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("THR", -239);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("HIS", -239);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("TRP", -212);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("HIS", -212);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("TYR", 34);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("HIS", 34);
        scoringMap.put("HIS", new HashMap<>()); scoringMap.get("HIS").put("VAL", 204);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("HIS", 204);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("ILE", -326);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("LEU", -160);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("ILE", -160);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("LYS", 194);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("ILE", 194);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("MET", -12);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("ILE", -12);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("PHE", -96);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("ILE", -96);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("PRO", 369);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("ILE", 369);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("SER", 206);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("ILE", 206);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("THR", 109);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("ILE", 109);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("TRP", -18);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("ILE", -18);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("TYR", -163);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("ILE", -163);
        scoringMap.put("ILE", new HashMap<>()); scoringMap.get("ILE").put("VAL", -232);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("ILE", -232);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("LEU", -278);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("LYS", 178);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("LEU", 178);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("MET", -106);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("LEU", -106);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("PHE", -195);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("LEU", -195);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("PRO", 218);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("LEU", 218);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("SER", 272);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("LEU", 272);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("THR", 225);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("LEU", 225);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("TRP", 81);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("LEU", 81);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("TYR", -93);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("LEU", -93);
        scoringMap.put("LEU", new HashMap<>()); scoringMap.get("LEU").put("VAL", -218);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("LEU", -218);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("LYS", 122);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("MET", 301);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("LYS", 301);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("PHE", -17);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("LYS", -17);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("PRO", -46);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("LYS", -46);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("SER", -58);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("LYS", -58);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("THR", -16);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("LYS", -16);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("TRP", 29);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("LYS", 29);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("TYR", -312);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("LYS", -312);
        scoringMap.put("LYS", new HashMap<>()); scoringMap.get("LYS").put("VAL", 269);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("LYS", 269);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("MET", -494);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("PHE", -272);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("MET", -272);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("PRO", 35);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("MET", 35);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("SER", 193);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("MET", 193);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("THR", 158);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("MET", 158);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("TRP", -5);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("MET", -5);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("TYR", -173);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("MET", -173);
        scoringMap.put("MET", new HashMap<>()); scoringMap.get("MET").put("VAL", -50);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("MET", -50);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("PHE", -206);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("PRO", -21);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("PHE", -21);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("SER", 114);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("PHE", 114);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("THR", 283);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("PHE", 283);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("TRP", 31);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("PHE", 31);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("TYR", -5);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("PHE", -5);
        scoringMap.put("PHE", new HashMap<>()); scoringMap.get("PHE").put("VAL", -42);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("PHE", -42);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("PRO", -210);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("SER", -162);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("PRO", -162);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("THR", -98);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("PRO", -98);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("TRP", -432);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("PRO", -432);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("TYR", -81);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("PRO", -81);
        scoringMap.put("PRO", new HashMap<>()); scoringMap.get("PRO").put("VAL", 46);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("PRO", 46);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("SER", -177);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("THR", -215);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("SER", -215);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("TRP", 129);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("SER", 129);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("TYR", 104);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("SER", 104);
        scoringMap.put("SER", new HashMap<>()); scoringMap.get("SER").put("VAL", 267);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("SER", 267);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("THR", -210);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("TRP", 95);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("THR", 95);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("TYR", 163);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("THR", 163);
        scoringMap.put("THR", new HashMap<>()); scoringMap.get("THR").put("VAL", 73);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("THR", 73);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("TRP", -20);
        scoringMap.put("TRP", new HashMap<>()); scoringMap.get("TRP").put("TYR", -95);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("TRP", -95);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("VAL", 101);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("TYR", 101);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("TYR", -6);
        scoringMap.put("TYR", new HashMap<>()); scoringMap.get("TYR").put("VAL", 107);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("TYR", 107);
        scoringMap.put("VAL", new HashMap<>()); scoringMap.get("VAL").put("VAL", -324);

        String folderPath = "C:\\Users\\logan\\OneDrive\\Desktop\\Computational Structural Biology"; //".pdb folder path"
        String outputFile = "output.txt"; // currently outputs to program file location

        try (BufferedWriter allResultsWriter = new BufferedWriter(new FileWriter(outputFile))) 
        {
            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files != null) 
            {
                for (File file : files) 
                {
                    if (file.isFile() && file.getName().endsWith(".pdb")) 
                    {
                        try 
                        {
                            Map<Integer, ModelInfo> modelMap = parsePDBFile(file.getAbsolutePath());

                            // write the results to output file
                            for (Integer modelNumber : modelMap.keySet()) 
                            {
                                ModelInfo modelInfo = modelMap.get(modelNumber);
                                String pdbId = extractPDBId(file.getName());
                                allResultsWriter.write("PDB ID: " + pdbId + "\n");
                                allResultsWriter.write("Model Number: " + modelNumber + "\n");
                                allResultsWriter.write("Energy Score: " + modelInfo.getOverallScore() + "\n");
                                allResultsWriter.write("--------------\n");
                            }
                        } 
                        catch (IOException e) 
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    private static Map<Integer, ModelInfo> parsePDBFile(String pdbFilePath) throws IOException 
    {
        Map<Integer, ModelInfo> modelMap = new HashMap<>();
        int currentModel = 1; // Initialize to a default value

        try (BufferedReader br = new BufferedReader(new FileReader(pdbFilePath))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                if (line.startsWith("MODEL")) 
                {
                    currentModel = Integer.parseInt(line.substring(10).trim());
                    modelMap.put(currentModel, new ModelInfo());
                }
                else if (line.startsWith("ATOM")) 
                {
                    String residueKey = line.substring(21, 27).trim();
                    String residueCode = line.substring(17, 20).trim();
                    double x = Double.parseDouble(line.substring(30, 38).trim());
                    double y = Double.parseDouble(line.substring(38, 46).trim());
                    double z = Double.parseDouble(line.substring(46, 54).trim());

                    modelMap.computeIfAbsent(currentModel, k -> new ModelInfo()).addResidue(residueKey, residueCode, x, y, z);
                }
            }
        }
        return modelMap;
    }

    private static void writeOutputToFile(ModelInfo modelInfo, String outputFileName) throws IOException 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) 
        {
            writer.write("Energy Score: " + modelInfo.getOverallScore() + "\n");
        }
    }

    //get the pbdID
    private static String extractPDBId(String fileName) 
    {
        return fileName.substring(0, 4).toUpperCase();
    }


    private static class ModelInfo 
    {
        private Map<String, ResidueInfo> residues = new HashMap<>();
        private Set<String> scoredPairs = new HashSet<>();

        public void addResidue(String residueKey, String residueCode, double x, double y, double z) 
        {
            residues.put(residueKey, new ResidueInfo(residueCode, x, y, z));
        }

        public double getOverallScore() 
        {

            double overallScore = 0.0;

            // calculate overall score based on residue interaction in 3d space
            for (ResidueInfo targetResidue : residues.values()) 
            {
                for (ResidueInfo otherResidue : residues.values()) 
                {
                    if (targetResidue != otherResidue) {
                        String pairKey = getPairKey(targetResidue.residueCode, otherResidue.residueCode);

                        // make sure the residue pair hasn't been scored
                        if (!scoredPairs.contains(pairKey)) 
                        {
                            double distance = calculateDistance(targetResidue, otherResidue);
                            double residueScore = calculateResidueScore(targetResidue, otherResidue);
                            if (distance <= 15) //this is the distance constraint to determine if a score is relavent or not
                            {
                                overallScore += residueScore;
                                scoredPairs.add(pairKey);
                            }
                        }
                    }
                }
            }
            return overallScore;
        }

        
        private String getPairKey(String code1, String code2) 
        {
            return code1.compareTo(code2) < 0 ? code1 + "_" + code2 : code2 + "_" + code1;
        }
        //determine relative distance from the center of a residue to another
        private double calculateDistance(ResidueInfo residue1, ResidueInfo residue2) 
        {
            double dx = residue1.centerX - residue2.centerX;
            double dy = residue1.centerY - residue2.centerY;
            double dz = residue1.centerZ - residue2.centerZ;
            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        }


        private double calculateResidueScore(ResidueInfo targetResidue, ResidueInfo otherResidue) 
        {
            String targetCode = targetResidue.residueCode;
            String otherCode = otherResidue.residueCode;
            

            if (scoringMap.containsKey(targetCode) && scoringMap.get(targetCode).containsKey(otherCode)) 
            {
                return scoringMap.get(targetCode).get(otherCode);
            }
            // default value is something wierd happens
            return 0.0;
        }
    }

    private static class ResidueInfo 
    {
        String residueCode;
        double centerX, centerY, centerZ;
        int count;
        
        //collected info

        public ResidueInfo(String residueCode, double x, double y, double z) 
        {
            this.residueCode = residueCode;
            this.centerX = x;
            this.centerY = y;
            this.centerZ = z;
            this.count = 1;
        }
    }
}


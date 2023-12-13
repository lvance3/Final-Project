

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RelativeEnergyCalculator {

    private static final String FILE_EXTENSION = ".pdb"; //allowing for posible expansion of supported file types
    private static final String OUTPUT_FILE = "output.txt";

    private static final String[] RESIDUES = {"ALA", "ARG", "ASN", "ASP", "CYS", "GLN", "GLU", "GLY", "HIS", "ILE", "LEU", "LYS", "MET", "PHE", "PRO", "SER", "THR", "TRP", "TYR", "VAL"};

    private static ConcurrentHashMap<String, ConcurrentHashMap<String, Double>> scoringMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        initializeScoringMap();
        PDBParserGUI pdbParserGUI = new PDBParserGUI();
        pdbParserGUI.showGUI();

    }

        private static void initializeScoringMap() {
            // Define scores for residue pairs
            Map<String, Double> defaultScores = getDefaultScores();
        
            for (String residue1 : RESIDUES) {
                scoringMap.put(residue1, new ConcurrentHashMap<>(defaultScores));
                scoringMap.get(residue1).putAll(getScoresForResidue(residue1));
            }
            //System.out.println("Scoring Map: " + scoringMap);
        }

    private static Map<String, Double> getDefaultScores() {
        Map<String, Double> defaultScores = new HashMap<>();
        for (String residue : RESIDUES) {
            defaultScores.put(residue, 0.0);
        }
        return defaultScores;
    }

    private static ConcurrentHashMap<String, Double> getScoresForResidue(String residue) {
        ConcurrentHashMap<String, Double> scores = new ConcurrentHashMap<>();
    
        // Scores for ALA
        if ("ALA".equals(residue)) {
            scores.put("ALA", -140.0); 
            scores.put("ARG", 268.0);
            scores.put("ASN", 105.0);
            scores.put("ASP", 217.0);
            scores.put("CYS", 330.0);
            scores.put("GLN", 27.0);
            scores.put("GLU", 122.0);
            scores.put("GLY", 11.0);
            scores.put("HIS", 58.0);
            scores.put("ILE", -114.0);
            scores.put("LEU", -182.0);
            scores.put("LYS", 123.0);
            scores.put("MET", -74.0);
            scores.put("PHE", -65.0);
            scores.put("PRO", 174.0);
            scores.put("SER", 169.0);
            scores.put("THR", 58.0);
            scores.put("TRP", 51.0);
            scores.put("TYR", 53.0);
            scores.put("VAL", -105.0);
        }
        
        // Scores for ARG
        if ("ARG".equals(residue)) {
            scores.put("ALA", 268.0); 
            scores.put("ARG", -18.0);
            scores.put("ASN", -85.0);
            scores.put("ASP", -616.0);
            scores.put("CYS", 67.0);
            scores.put("GLN", -60.0);
            scores.put("GLU", -564.0);
            scores.put("GLY", -80.0);
            scores.put("HIS", -263.0);
            scores.put("ILE", 110.0);
            scores.put("LEU", 263.0);
            scores.put("LYS", 310.0);
            scores.put("MET", 304.0);
            scores.put("PHE", 62.0);
            scores.put("PRO", -33.0);
            scores.put("SER", -80.0);
            scores.put("THR", 60.0);
            scores.put("TRP", -150.0);
            scores.put("TYR", -132.0);
            scores.put("VAL", 171.0);
        }
    
        // Scores for ASN
        if ("ASN".equals(residue)) {
            scores.put("ALA", 105.0); 
            scores.put("ARG", -85.0);
            scores.put("ASN", -435.0);
            scores.put("ASP", -417.0);
            scores.put("CYS", 106.0);
            scores.put("GLN", -200.0);
            scores.put("GLU", -136.0);
            scores.put("GLY", -103.0);
            scores.put("HIS", 61.0);
            scores.put("ILE", 351.0);
            scores.put("LEU", 358.0);
            scores.put("LYS", -210.0);
            scores.put("MET", 314.0);
            scores.put("PHE", 201.0);
            scores.put("PRO", -212.0);
            scores.put("SER", -223.0);
            scores.put("THR", -231.0);
            scores.put("TRP", -18.0);
            scores.put("TYR", 53.0);
            scores.put("VAL", 298.0);
        }
        // Scores for ASP
        if ("ASP".equals(residue)) {
            scores.put("ALA", 217.0); 
            scores.put("ARG", -616.0);
            scores.put("ASN", -417.0);
            scores.put("ASP", 17.0);
            scores.put("CYS", 278.0);
            scores.put("GLN", 67.0);
            scores.put("GLU", 140.0);
            scores.put("GLY", -267.0);
            scores.put("HIS", -454.0);
            scores.put("ILE", 318.0);
            scores.put("LEU", 370.0);
            scores.put("LYS", -564.0);
            scores.put("MET", 211.0);
            scores.put("PHE", 284.0);
            scores.put("PRO", -28.0);
            scores.put("SER", -299.0);
            scores.put("THR", -203.0);
            scores.put("TRP", 104.0);
            scores.put("TYR", 268.0);
            scores.put("VAL", 431.0);
        }
        // Scores for CYS
        if ("CYS".equals(residue)) {
            scores.put("ALA", 330.0); 
            scores.put("ARG", 67.0);
            scores.put("ASN", 106.0);
            scores.put("ASP", 278.0);
            scores.put("CYS", -1923.0);
            scores.put("GLN", 191.0);
            scores.put("GLU", 122.0);
            scores.put("GLY", 88.0);
            scores.put("HIS", 190.0);
            scores.put("ILE", 154.0);
            scores.put("LEU", 238.0);
            scores.put("LYS", 246.0);
            scores.put("MET", 50.0);
            scores.put("PHE", 34.0);
            scores.put("PRO", 105.0);
            scores.put("SER", 7.0);
            scores.put("THR", 372.0);
            scores.put("TRP", 52.0);
            scores.put("TYR", 62.0);
            scores.put("VAL", 196.0);
        }
        // Scores for GLN
        if ("GLN".equals(residue)) {
            scores.put("ALA", 27.0); 
            scores.put("ARG", -18.0);
            scores.put("ASN", -200.0);
            scores.put("ASP", 67.0);
            scores.put("CYS", 191.0);
            scores.put("GLN", -115.0);
            scores.put("GLU", 10.0);
            scores.put("GLY", -72.0);
            scores.put("HIS", 272.0);
            scores.put("ILE", 243.0);
            scores.put("LEU", 25.0);
            scores.put("LYS", -184.0);
            scores.put("MET", 32.0);
            scores.put("PHE", 72.0);
            scores.put("PRO", -81.0);
            scores.put("SER", -163.0);
            scores.put("THR", -151.0);
            scores.put("TRP", -12.0);
            scores.put("TYR", -90.0);
            scores.put("VAL", 180.0);
        }
        // Scores for GLU
        if ("GLU".equals(residue)) {
            scores.put("ALA", 122.0); 
            scores.put("ARG", -564.0);
            scores.put("ASN", -136.0);
            scores.put("ASP", 140.0);
            scores.put("CYS", 122.0);
            scores.put("GLN", 10.0);
            scores.put("GLU", 68.0);
            scores.put("GLY", -31.0);
            scores.put("HIS", -368.0);
            scores.put("ILE", 294.0);
            scores.put("LEU", 255.0);
            scores.put("LYS", -667.0);
            scores.put("MET", 141.0);
            scores.put("PHE", 235.0);
            scores.put("PRO", -102.0);
            scores.put("SER", -212.0);
            scores.put("THR", -211.0);
            scores.put("TRP", 157.0);
            scores.put("TYR", 269.0);
            scores.put("VAL", 235.0);
        }
        // Scores for GLY
        if ("GLY".equals(residue)) {
            scores.put("ALA", 11.0); 
            scores.put("ARG", -80.0);
            scores.put("ASN", -103.0);
            scores.put("ASP", -167.0);
            scores.put("CYS", 88.0);
            scores.put("GLN", -72.0);
            scores.put("GLU", -31.0);
            scores.put("GLY", -288.0);
            scores.put("HIS", 74.0);
            scores.put("ILE", 179.0);
            scores.put("LEU", 237.0);
            scores.put("LYS", 95.0);
            scores.put("MET", 13.0);
            scores.put("PHE", 114.0);
            scores.put("PRO", -73.0);
            scores.put("SER", -186.0);
            scores.put("THR", -73.0);
            scores.put("TRP", -69.0);
            scores.put("TYR", 58.0);
            scores.put("VAL", 202.0);
        }
        // Scores for HIS
        if ("HIS".equals(residue)) {
            scores.put("ALA", 58.0); 
            scores.put("ARG", -263.0);
            scores.put("ASN", 61.0);
            scores.put("ASP", -454.0);
            scores.put("CYS", 190.0);
            scores.put("GLN", 272.0);
            scores.put("GLU", -368.0);
            scores.put("GLY", 74.0);
            scores.put("HIS", -448.0);
            scores.put("ILE", 294.0);
            scores.put("LEU", 200.0);
            scores.put("LYS", 54.0);
            scores.put("MET", -7.0);
            scores.put("PHE", 158.0);
            scores.put("PRO", -65.0);
            scores.put("SER", -133.0);
            scores.put("THR", -239.0);
            scores.put("TRP", -212.0);
            scores.put("TYR", 34.0);
            scores.put("VAL", 204.0);
        }
        // Scores for ILE
        if ("ILE".equals(residue)) {
            scores.put("ALA", -114.0); 
            scores.put("ARG", 110.0);
            scores.put("ASN", 351.0);
            scores.put("ASP", 318.0);
            scores.put("CYS", 154.0);
            scores.put("GLN", 243.0);
            scores.put("GLU", 294.0);
            scores.put("GLY", 179.0);
            scores.put("HIS", 294.0);
            scores.put("ILE", -326.0);
            scores.put("LEU", -160.0);
            scores.put("LYS", 194.0);
            scores.put("MET", -12.0);
            scores.put("PHE", -96.0);
            scores.put("PRO", 369.0);
            scores.put("SER", 206.0);
            scores.put("THR", 109.0);
            scores.put("TRP", -18.0);
            scores.put("TYR", -163.0);
            scores.put("VAL", -232.0);
        }
        // Scores for LEU
        if ("LEU".equals(residue)) {
            scores.put("ALA", -182.0); 
            scores.put("ARG", 263.0);
            scores.put("ASN", 358.0);
            scores.put("ASP", 370.0);
            scores.put("CYS", 238.0);
            scores.put("GLN", 25.0);
            scores.put("GLU", 255.0);
            scores.put("GLY", 237.0);
            scores.put("HIS", 200.0);
            scores.put("ILE", -160.0);
            scores.put("LEU", -278.0);
            scores.put("LYS", 178.0);
            scores.put("MET", -106.0);
            scores.put("PHE", -195.0);
            scores.put("PRO", 218.0);
            scores.put("SER", 272.0);
            scores.put("THR", 225.0);
            scores.put("TRP", 81.0);
            scores.put("TYR", -93.0);
            scores.put("VAL", -218.0);
        }
        // Scores for LYS
        if ("LYS".equals(residue)) {
            scores.put("ALA", 123.0); 
            scores.put("ARG", 310.0);
            scores.put("ASN", -201.0);
            scores.put("ASP", -564.0);
            scores.put("CYS", 246.0);
            scores.put("GLN", -184.0);
            scores.put("GLU", -667.0);
            scores.put("GLY", 95.0);
            scores.put("HIS", 54.0);
            scores.put("ILE", 194.0);
            scores.put("LEU", 178.0);
            scores.put("LYS", 122.0);
            scores.put("MET", 301.0);
            scores.put("PHE", -17.0);
            scores.put("PRO", -46.0);
            scores.put("SER", -58.0);
            scores.put("THR", -16.0);
            scores.put("TRP", 29.0);
            scores.put("TYR", -312.0);
            scores.put("VAL", 269.0);
        }
        // Scores for MET
        if ("MET".equals(residue)) {
            scores.put("ALA", -74.0); 
            scores.put("ARG", 304.0);
            scores.put("ASN", 314.0);
            scores.put("ASP", 211.0);
            scores.put("CYS", 50.0);
            scores.put("GLN", 32.0);
            scores.put("GLU", 141.0);
            scores.put("GLY", 13.0);
            scores.put("HIS", -7.0);
            scores.put("ILE", -12.0);
            scores.put("LEU", -106.0);
            scores.put("LYS", 301.0);
            scores.put("MET", -494.0);
            scores.put("PHE", -272.0);
            scores.put("PRO", 35.0);
            scores.put("SER", 193.0);
            scores.put("THR", 158.0);
            scores.put("TRP", -5.0);
            scores.put("TYR", -173.0);
            scores.put("VAL", -50.0);
        }
        // Scores for PHE
        if ("PHE".equals(residue)) {
            scores.put("ALA", -65.0); 
            scores.put("ARG", 62.0);
            scores.put("ASN", 201.0);
            scores.put("ASP", 284.0);
            scores.put("CYS", 34.0);
            scores.put("GLN", 72.0);
            scores.put("GLU", 235.0);
            scores.put("GLY", 114.0);
            scores.put("HIS", 158.0);
            scores.put("ILE", -96.0);
            scores.put("LEU", -195.0);
            scores.put("LYS", -17.0);
            scores.put("MET", -272.0);
            scores.put("PHE", -206.0);
            scores.put("PRO", -21.0);
            scores.put("SER", 114.0);
            scores.put("THR", 283.0);
            scores.put("TRP", 31.0);
            scores.put("TYR", -5.0);
            scores.put("VAL", -42.0);
        }
        // Scores for PRO
        if ("PRO".equals(residue)) {
            scores.put("ALA", 174.0); 
            scores.put("ARG", -33.0);
            scores.put("ASN", -212.0);
            scores.put("ASP", -28.0);
            scores.put("CYS", 105.0);
            scores.put("GLN", -81.0);
            scores.put("GLU", -102.0);
            scores.put("GLY", -73.0);
            scores.put("HIS", -65.0);
            scores.put("ILE", 369.0);
            scores.put("LEU", 218.0);
            scores.put("LYS", -46.0);
            scores.put("MET", 35.0);
            scores.put("PHE", -21.0);
            scores.put("PRO", -210.0);
            scores.put("SER", -162.0);
            scores.put("THR", -98.0);
            scores.put("TRP", -432.0);
            scores.put("TYR", -81.0);
            scores.put("VAL", 46.0);
        }
        // Scores for SER
        if ("SER".equals(residue)) {
            scores.put("ALA", 169.0); 
            scores.put("ARG", -80.0);
            scores.put("ASN", -223.0);
            scores.put("ASP", -299.0);
            scores.put("CYS", 7.0);
            scores.put("GLN", -163.0);
            scores.put("GLU", -212.0);
            scores.put("GLY", -186.0);
            scores.put("HIS", -133.0);
            scores.put("ILE", 206.0);
            scores.put("LEU", 272.0);
            scores.put("LYS", -58.0);
            scores.put("MET", 193.0);
            scores.put("PHE", 114.0);
            scores.put("PRO", -162.0);
            scores.put("SER", -177.0);
            scores.put("THR", -215.0);
            scores.put("TRP", 129.0);
            scores.put("TYR", 104.0);
            scores.put("VAL", 267.0);
        }
        // Scores for THR
        if ("THR".equals(residue)) {
            scores.put("ALA", 58.0); 
            scores.put("ARG", 60.0);
            scores.put("ASN", -231.0);
            scores.put("ASP", -203.0);
            scores.put("CYS", 372.0);
            scores.put("GLN", -151.0);
            scores.put("GLU", -211.0);
            scores.put("GLY", 73.0);
            scores.put("HIS", -239.0);
            scores.put("ILE", 109.0);
            scores.put("LEU", 225.0);
            scores.put("LYS", -26.0);
            scores.put("MET", 158.0);
            scores.put("PHE", 283.0);
            scores.put("PRO", -98.0);
            scores.put("SER", -215.0);
            scores.put("THR", -210.0);
            scores.put("TRP", 95.0);
            scores.put("TYR", 163.0);
            scores.put("VAL", 73.0);
        }
        // Scores for TRP
        if ("TRP".equals(residue)) {
            scores.put("ALA", 51.0); 
            scores.put("ARG", -150.0);
            scores.put("ASN", -18.0);
            scores.put("ASP", 104.0);
            scores.put("CYS", 52.0);
            scores.put("GLN", -12.0);
            scores.put("GLU", 157.0);
            scores.put("GLY", -69.0);
            scores.put("HIS", -212.0);
            scores.put("ILE", -18.0);
            scores.put("LEU", 81.0);
            scores.put("LYS", 29.0);
            scores.put("MET", -5.0);
            scores.put("PHE", 31.0);
            scores.put("PRO", -432.0);
            scores.put("SER", 129.0);
            scores.put("THR", 95.0);
            scores.put("TRP", -20.0);
            scores.put("TYR", -95.0);
            scores.put("VAL", 101.0);
        }
        // Scores for TYR
        if ("TYR".equals(residue)) {
            scores.put("ALA", 53.0); 
            scores.put("ARG", -132.0);
            scores.put("ASN", 53.0);
            scores.put("ASP", 268.0);
            scores.put("CYS", 62.0);
            scores.put("GLN", -90.0);
            scores.put("GLU", 269.0);
            scores.put("GLY", 58.0);
            scores.put("HIS", 34.0);
            scores.put("ILE", -163.0);
            scores.put("LEU", -93.0);
            scores.put("LYS", -312.0);
            scores.put("MET", -173.0);
            scores.put("PHE", -5.0);
            scores.put("PRO", -81.0);
            scores.put("SER", 104.0);
            scores.put("THR", 163.0);
            scores.put("TRP", -95.0);
            scores.put("TYR", -6.0);
            scores.put("VAL", 107.0);
        }
        // Scores for VAL
        if ("VAL".equals(residue)) {
            scores.put("ALA", -105.0); 
            scores.put("ARG", 171.0);
            scores.put("ASN", 298.0);
            scores.put("ASP", 431.0);
            scores.put("CYS", 196.0);
            scores.put("GLN", 180.0);
            scores.put("GLU", 235.0);
            scores.put("GLY", 202.0);
            scores.put("HIS", 204.0);
            scores.put("ILE", -232.0);
            scores.put("LEU", -218.0);
            scores.put("LYS", 269.0);
            scores.put("MET", -50.0);
            scores.put("PHE", -42.0);
            scores.put("PRO", 46.0);
            scores.put("SER", 267.0);
            scores.put("THR", 73.0);
            scores.put("TRP", 101.0);
            scores.put("TYR", 107.0);
            scores.put("VAL", -324.0);
        }

        // if any changes to a residue pair ar made, remember to change the inverse as well
       
        return scores;
    }

    private static void processPDBFiles(String folderPath, BufferedWriter allResultsWriter, JProgressBar progressBar, int numCores) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
    
        if (files != null) {
            ExecutorService executorService = Executors.newFixedThreadPool(numCores);
    
            try {
                int totalFiles = files.length;
                int filesProcessed = 0;
    
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(FILE_EXTENSION)) {
                        executorService.submit(() -> processSinglePDBFile(file, allResultsWriter));
    
                        // Update progress bar
                        filesProcessed++;
                        int progress = (int) ((double) filesProcessed / totalFiles * 100);
                        SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
                    }
                }
    
                executorService.shutdown();
                executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void processSinglePDBFile(File file, BufferedWriter allResultsWriter) {
        try {
            Map<Integer, ModelInfo> modelMap = parsePDBFile(file.getAbsolutePath());
    
            for (Integer modelNumber : modelMap.keySet()) {
                ModelInfo modelInfo = modelMap.get(modelNumber);
                String pdbId = extractPDBId(file.getName());
                writeResultsToOutput(allResultsWriter, pdbId, modelNumber, modelInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processSinglePDBFile(File file) {
        try {
            Map<Integer, ModelInfo> modelMap = parsePDBFile(file.getAbsolutePath());
    
            try (BufferedWriter allResultsWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
                for (Integer modelNumber : modelMap.keySet()) {
                    ModelInfo modelInfo = modelMap.get(modelNumber);
                    String pdbId = extractPDBId(file.getName());
                    writeResultsToOutput(allResultsWriter, pdbId, modelNumber, modelInfo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeResultsToOutput(BufferedWriter allResultsWriter, String pdbId, Integer modelNumber, ModelInfo modelInfo) throws IOException {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("PDB ID: ").append(pdbId).append("\n");
        resultBuilder.append("Model Number: ").append(modelNumber).append("\n");
        resultBuilder.append("Energy Score: ").append(modelInfo.getOverallScore()).append("\n");
        resultBuilder.append("---------------------\n");
    
        synchronized (allResultsWriter) {
            allResultsWriter.write(resultBuilder.toString());
        }
    }
    
    private static Map<Integer, ModelInfo> parsePDBFile(String pdbFilePath) throws IOException {
        Map<Integer, ModelInfo> modelMap = new HashMap<>();
        int currentModel = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(pdbFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("MODEL")) {
                    currentModel = Integer.parseInt(line.substring(10).trim());
                    modelMap.put(currentModel, new ModelInfo());
                } else if (line.startsWith("ATOM")) {
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

    private static String extractPDBId(String fileName) {
        return fileName.substring(0, 4).toUpperCase();
    }

    private static class ModelInfo {
        private ConcurrentHashMap<String, ResidueInfo> residues = new ConcurrentHashMap<>();
        private Set<String> scoredPairs = Collections.newSetFromMap(new ConcurrentHashMap<>());

        public void addResidue(String residueKey, String residueCode, double x, double y, double z) {
            residues.put(residueKey, new ResidueInfo(residueCode, x, y, z));
        }

        public double getOverallScore() {
            double overallScore = 0.0;

            for (ResidueInfo targetResidue : residues.values()) {
                for (ResidueInfo otherResidue : residues.values()) {
                    if (targetResidue != otherResidue) {
                        String pairKey = getPairKey(targetResidue.residueCode, otherResidue.residueCode);

                        if (!scoredPairs.contains(pairKey)) {
                            double distance = calculateDistance(targetResidue, otherResidue);
                            double residueScore = calculateResidueScore(targetResidue, otherResidue);
                            if (distance <= 7.5) {
                                overallScore += residueScore;
                                scoredPairs.add(pairKey);
                            }
                        }
                    }
                }
            }
            return overallScore;
        }

        private String getPairKey(String code1, String code2) {
            return code1.compareTo(code2) < 0 ? code1 + "_" + code2 : code2 + "_" + code1;
        }

        private double calculateDistance(ResidueInfo residue1, ResidueInfo residue2) {
            double dx = residue1.centerX - residue2.centerX;
            double dy = residue1.centerY - residue2.centerY;
            double dz = residue1.centerZ - residue2.centerZ;
            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        }

        private double calculateResidueScore(ResidueInfo targetResidue, ResidueInfo otherResidue) {
            String targetCode = targetResidue.residueCode;
            String otherCode = otherResidue.residueCode;
        
            //System.out.println("Target Code: " + targetCode + ", Other Code: " + otherCode);
        
            if (scoringMap.containsKey(targetCode) && scoringMap.get(targetCode).containsKey(otherCode)) {
                return scoringMap.get(targetCode).get(otherCode);
            }
            return 0.0;
        }
    }
    
    private static class ResidueInfo {
        String residueCode;
        double centerX, centerY, centerZ;

        public ResidueInfo(String residueCode, double x, double y, double z) {
            this.residueCode = residueCode;
            this.centerX = x;
            this.centerY = y;
            this.centerZ = z;
        }
    }
    public static class PDBParserGUI {

        private JFrame frame;
        private JTextField folderPathField;
        private JTextField distanceField;
        private JTextField coresField;
        private JProgressBar progressBar;
        private BufferedWriter allResultsWriter;

        public PDBParserGUI() {
            initialize();
        }

        public JTextField getDistanceField() {
            return distanceField;
        }

        public void showTaskFinishedDialog() {
            JOptionPane.showMessageDialog(frame, "Task finished successfully!");
        }

        public JProgressBar getProgressBar() {
            return progressBar;
        }

        public BufferedWriter getAllResultsWriter() {
            return allResultsWriter;
        }

        public void setAllResultsWriter(BufferedWriter writer) {
            allResultsWriter = writer;
        }

        private void handlePDBParserError(Exception ex, JFrame frame) {
            JOptionPane.showMessageDialog(frame, "Error during PDB parsing: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        private void initialize() {
            frame = new JFrame("PDB Parser GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel folderLabel = new JLabel("Select Folder Path:");
            folderPathField = new JTextField();
            folderPathField.setPreferredSize(new Dimension(200, 30)); // Set preferred size
            JButton browseButton = new JButton("Browse");
    
            JLabel distanceLabel = new JLabel("Set Distance Parameter:");
            distanceField = new JTextField();
            distanceField.setPreferredSize(new Dimension(200, 30)); // Set preferred size
            
            JLabel coresLabel = new JLabel("Number of Cores:");
            coresField = new JTextField();
            coresField.setPreferredSize(new Dimension(50, 30));

            progressBar = new JProgressBar();
            progressBar.setStringPainted(true);

            JButton runButton = new JButton("Run");

            GroupLayout layout = new GroupLayout(frame.getContentPane());
            frame.setLayout(layout);

            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);

            GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(folderLabel)
                .addComponent(distanceLabel)
                .addComponent(coresLabel)); // Add the cores label
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(folderPathField)
                .addComponent(distanceField)
                .addComponent(coresField)); // Add the cores field
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(browseButton)
                .addComponent(runButton));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(folderLabel)
                .addComponent(folderPathField)
                .addComponent(browseButton));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(distanceLabel)
                .addComponent(distanceField)
                .addComponent(runButton));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(coresLabel)
                .addComponent(coresField)); // Add the cores field
        layout.setVerticalGroup(vGroup);

            browseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int result = fileChooser.showOpenDialog(frame);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        folderPathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    }
                }
            });

            runButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    runPDBParser();
                }
            });
    
            frame.pack(); // Adjust the frame size based on the components
            frame.setVisible(true);
}


        public void showGUI() {
            frame.setVisible(true);
        }

        public String getFolderPath() {
            return folderPathField.getText();
        }
    
        public JFrame getFrame() {
            return frame;
        }

        private void runPDBParser() {
            String folderPath = folderPathField.getText();
        
            try {
                double distanceParameter = Double.parseDouble(distanceField.getText());
                int numCores = Integer.parseInt(coresField.getText());
        
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        try (BufferedWriter allResultsWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
                            processPDBFiles(folderPath, allResultsWriter, progressBar, numCores);
                            showTaskFinishedDialog();
                        } catch (Exception ex) {
                            handlePDBParserError(ex, frame);
                        }
                        return null;
                    }
                };
        
                worker.execute();
        
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
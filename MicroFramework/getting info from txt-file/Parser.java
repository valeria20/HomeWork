/**
 * Instruction's parser
 * @author Valeria
 */
public class Parser {
    /**
     * getting command of instruction
     * @param instruction-the line with instruction from txt-file
     * @return the command of instruction
     */

    public static String parseInstruction(String instruction) {
        String command = instruction.split("\\s")[0];
        return command;
    }
    /**
     * getting information about what to use and what  to check
     * @param instruction-the line with instruction from txt-file
     * @return the first argument after command
     */

    public static String parseFirstArgument(String instruction) {
        return instruction.split("\\s")[1];
    }

    /**
     * getting information about what to use and what  to check
     * @param instruction
     * @return the second argument after command
     */

    public static String parseSecondArgument(String instruction) {
        return instruction.split("\\s")[2];
    }
}

import java.util.ArrayList;

public class ProtocolParser {

    private boolean isProcessing;
    private int currentlyProcessing;
    private ArrayList<String> mMessagePackage;
    private int mNumTargets;


    public ProtocolParser() {
        mNumTargets = -1;
    }

    //returns the constructed package pieced together from input and null if package is still incomplete
    public ArrayList<String> processNewWord(int word) {
        if(isProcessing == false) {
            if (word == 1) {
                currentlyProcessing = 1;
                processWheelVelocityMessage(word);
            } else if (word == 2) {
                currentlyProcessing = 2;
                processVisionTargetMessage(word);
            }
            isProcessing = true;
        } else {
            if(currentlyProcessing == 1) {
                return processWheelVelocityMessage(word);
            }
            else if(currentlyProcessing == 2) {
                return processVisionTargetMessage(word);
            }
        }
        return null;
    }

    private ArrayList<String> processWheelVelocityMessage(int word) {
        if(!isProcessing) {
            mMessagePackage = new ArrayList<>();
            mMessagePackage.add("Wheel Velocity Message: ");
        } else {
            mMessagePackage.add(word + "mm/s ");
        }

        if(mMessagePackage.size() == 3) {
            isProcessing = false;
            currentlyProcessing = -1;
            return mMessagePackage;
        }
        return null;
    }

    private ArrayList<String> processVisionTargetMessage(int word) {
        if(!isProcessing) {
            mMessagePackage = new ArrayList<>();
            mMessagePackage.add("Vision Target Message: ");
        } else {

            if(mMessagePackage.size() == 1) {
                mNumTargets = word;
                mMessagePackage.add(word + " targets ");
            }
            else if(mMessagePackage.size() > 1 && mMessagePackage.size() % 2 == 0) {
                mMessagePackage.add("X " + word + " ");
            }
            else if(mMessagePackage.size() > 1 && mMessagePackage.size() % 2 == 1) {
                mMessagePackage.add("Y " + word + " ");
            }
        }

        if(mNumTargets != -1 && mMessagePackage.size() == (2 + mNumTargets*2)) {
            isProcessing = false;
            currentlyProcessing = -1;
            mNumTargets = -1;
            return mMessagePackage;
        }
        return null;
    }
}

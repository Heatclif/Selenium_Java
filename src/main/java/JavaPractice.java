
public class JavaPractice {

    interface IPrintWord {
        default void printWord(String word) {
            System.out.printf("IPrintWord: %s%n", word);
        }
        void printWord(String word, int times);
    }

    static abstract class ABPrintWord {
        void printWord(String word) {
            System.out.printf("ABPrintWord: %s%n", word);
        }
        abstract void printWord(String word, int times);
    }

    static class APrintWord implements IPrintWord {
        @Override
        public void printWord(String word) {
            System.out.printf("A PrintWord: %s%n", word);
        }

        @Override
        public void printWord(String word, int times) {
            for (int i = 0; i < times; ++i) {
                printWord(word);
            }
        }
    }

    static class BPrintWord implements IPrintWord {
        @Override
        public void printWord(String word, int times) {
            for (int i = 0; i < times; ++i) {
                printWord(word);
            }
        }
    }

    public static void main(String[] args) {
        APrintWord aPrintWord = new APrintWord();
        BPrintWord bPrintWord = new BPrintWord();

        ABPrintWord abPrintWord = new ABPrintWord() {
            @Override
            void printWord(String word, int times) {
                for (int i = 0; i < times-1; ++i) {
                    printWord(word);
                }
            }
        };

        abPrintWord.printWord("Boy Girl", 4);
        abPrintWord.printWord("Boy Girl 2", 3);

        aPrintWord.printWord("Boy");
        aPrintWord.printWord("Girl", 3);
        bPrintWord.printWord("Boy");
        bPrintWord.printWord("Girl", 2);
    }
}

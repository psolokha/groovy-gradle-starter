package org.example.examples

/**
 Добавить возможность складывать различные единицы измерения:
 3см + 1м - 25 мм = 1005 мм
 Напрмер 3.cm + 1.m - 25.mm = 1005 (mm)
 */
class Example2 {
    static void main(String[] args) {
        /**
             Integer.metaClass.getCm = {
             delegate * 10
             }
             Integer.metaClass.getM = {
             delegate.cm * 100
             }
             Integer.metaClass.getMm = {
             delegate
             }
         */
        Integer.metaClass {
            getCm = {
                delegate * 10
            }
            getM = {
                delegate.cm * 100
            }
            getMm = {
                delegate
            }
        }

        def result = 3.cm + 1.m - 25.mm
        assert result == 1005
    }

    //Using @Categories and use()
    private static void firstOption(String[] args) {
        use(IntegerMethods) {

            def result = 3.cm + 1.m - 25.mm
            assert result == 1005

        }

    }


}

@Category(Integer)
class IntegerMethods {
    def getCm() {
        this * 10
    }

    def getMm() {
        this
    }

    def getM() {
        getCm() * 100
    }
}

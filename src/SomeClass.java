import javax.swing.*;

public  class SomeClass {

    // создаем колбек и его метод
    interface Callback{             //  Внутрнений класс(интерфейс)
        void callingBack();
    }

    Callback callback;            // Экземпляр(объект) внутреннего класса


    /**
     * Метод для назначение колбека
     * @param callback конкретная реализация функционального интерфейса
     */
    public void registerCallBack(Callback callback){
        this.callback = callback;          // Присваиваем реализацию нашему объекту
    }

    /**
     * Метод выводит диалоговое окно, а после демонстрирует колбек
     */
    void doSomething(){
        JOptionPane.showMessageDialog(null, "Выполняется работа");

        // вызываем метод обратного вызова
        callback.callingBack();
    }
}

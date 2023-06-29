public class StudentClass implements SomeClass.Callback{
    @Override
    public void callingBack() {
        System.out.println("Вызов callback студентами");
    }
}

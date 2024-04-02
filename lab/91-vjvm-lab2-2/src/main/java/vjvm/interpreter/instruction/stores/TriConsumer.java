package vjvm.interpreter.instruction.stores;

public interface TriConsumer<T1, T2, T> {
  void accept(T1 a, T2 b, T c);
}

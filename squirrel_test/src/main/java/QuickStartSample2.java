import org.squirrelframework.foundation.fsm.Condition;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

public class QuickStartSample2 {
    public static void main(String[] args) {
        // 3. Build State Transitions
        StateMachineBuilder<StateMachineSample, String, FSMEvent, MyContext> builder =
                StateMachineBuilderFactory.create(StateMachineSample.class, String.class, FSMEvent.class,
                        MyContext.class);
        builder.externalTransition().from("A").to("B").on(FSMEvent.ToB).when(new Condition<MyContext>() {
            @Override
            public boolean isSatisfied(MyContext context) {
                return context.callNumber.equals("123");
            }

            @Override
            public String name() {
                return "MyContext";
            }
        }).callMethod("fromAToB");
        builder.externalTransition().from("A").to("C").on(FSMEvent.ToB).when(new Condition<MyContext>() {
            @Override
            public boolean isSatisfied(MyContext context) {
                return context.callNumber.equals("456");
            }

            @Override
            public String name() {
                return "MyContext";
            }
        }).callMethod("fromAToC");
        builder.externalTransition().from("B").to("C").on(FSMEvent.ToC).callMethod("fromBToC");
        builder.onEntry("B").callMethod("ontoB");

        // 4. Use State Machine
        StateMachineSample fsm = builder.newStateMachine("A");
        //fsm.fire(FSMEvent.ToB, new MyContext("456"));
        //fsm.fire(FSMEvent.ToB, new MyContext("123"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("fire: AtoB");
                fsm.fire(FSMEvent.ToB, new MyContext("123"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("fire: AtoC");
                fsm.fire(FSMEvent.ToB, new MyContext("456"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("fire: BtoC");
                fsm.fire(FSMEvent.ToC);
            }
        }).start();

        System.out.println("Current state is " + fsm.getCurrentState());
    }

    // 1. Define State Machine Event
    enum FSMEvent {
        ToA, ToB, ToC, ToD
    }

    private static class MyContext {
        String callNumber;

        public MyContext(String callNumber) {
            this.callNumber = callNumber;
        }

        @Override
        public String toString() {
            return "MyContext{" + "callNumber='" + callNumber + '\'' + '}';
        }
    }

    // 2. Define State Machine Class
    static class StateMachineSample extends AbstractStateMachine<StateMachineSample, String, FSMEvent, MyContext> {
        protected void fromAToB(String from, String to, FSMEvent event, MyContext context) {
            try {
                Thread.sleep(3000);
                System.out.println("do: AtoB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Transition from '" + from + "' to '" + to + "' on event '" + event + "' with context "
                    + "'" + context + "'.");
        }

        protected void fromAToC(String from, String to, FSMEvent event, MyContext context) {
            System.out.println("Transition from '" + from + "' to '" + to + "' on event '" + event + "' with context "
                    + "'" + context + "'.");
        }

        protected void fromBToC(String from, String to, FSMEvent event, MyContext context) {
            System.out.println("do: BtoC");
            System.out.println("Transition from '" + from + "' to '" + to + "' on event '" + event + "' with context "
                    + "'" + context + "'.");
        }

        protected void ontoB(String from, String to, FSMEvent event, MyContext context) {
            System.out.println("Entry State \'" + to + "\'.");
        }
    }
}

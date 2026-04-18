package bai2.code;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class Customer {
    String id;
    String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Message {
    String id;
    String content;

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class Ticket {
      String id;
      String content;
      String timeStamp;

      public Ticket(String id, String content, String timeStamp) {
        this.id = id;
        this.content = content;
        this.timeStamp = timeStamp;
      }
}

class CustomerQueue {
    Queue<Customer> customers = new LinkedList<>();

    public void addCustomer(Customer customer) {
        customers.offer(customer);
        System.out.println( customer.name + " da vao hang doi");
    }

    public void processCustomerRequest() {
        if (customers.isEmpty()) {
            System.out.println("Khong con khach doi");
        } else {
            Customer tempCustomer = customers.poll();
            System.out.println("Dang xu ly: " + tempCustomer.name);
        }
    }
}

class MessageHistory {
    Stack<Message> messages = new Stack<>();

    public void typeMessage(Message message) {
        messages.push(message);
    }

    public void Undo() {
        if (!messages.empty()) {
            System.out.println("Xoa tin nhan sai: " + messages.pop().getContent());
        }
    }

    public void ViewLast() {
        if (!messages.empty()) {
            System.out.println("Tin nhan vua go: " + messages.peek().getContent());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CustomerQueue customerQueue = new CustomerQueue();
        Customer customerA = new Customer("01", "A");
        Customer customerB = new Customer("02", "B");
        customerQueue.addCustomer(customerA);
        customerQueue.addCustomer(customerB);

        customerQueue.processCustomerRequest();
        MessageHistory messageHistory = new MessageHistory();
        messageHistory.typeMessage(new Message("01", "Xin chao quy khach!"));
        messageHistory.typeMessage(new Message("02", "Ban can ho tro gi a?"));
        messageHistory.typeMessage(new Message("03", "Xin chao quy khach!"));
        messageHistory.Undo();

        customerQueue.processCustomerRequest();
    }
}

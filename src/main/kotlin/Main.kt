import kotlin.math.ceil

fun main(){
    var head = createLinkList()
//    val kth =findKthElementFromEnd(3,head)
//    println(kth.name)
//    var cycle =detectCycle(head)
//    println(cycle?.name)
    var cyc = floydsCycle(head)
    println(cyc?.name)
//    val  middle =findMiddleNode(head)
//    println(middle.name)
//    val middle= findMiddle(head)
//    println(middle.name)
//    transverseList(head)
//    removeAtPosition(5,head)
//    insertAtPosition(4,Node("Mary"),head)
//   head = insertAtHead(Node("Mary"),head)
//    transverseList(head)


}

class Node (var name:String){
    var next : Node ? = null
}


//Linked list is prudent that you return the head which is node1
//to add a new node you can say vallary.next = Peter



fun createLinkList(): Node {
    var node1 = Node("Susan")
    var node2 = Node ("Eunice")
    var node3 = Node ("Juliet")
    var node4 = Node ("Joy")
    var node5 = Node ("Vallary")
    var node6 = Node ("Elizabeth")
    var node7 = Node ("Joyeuse")

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node3


    return node1

}
//Transverse list that takes in the head which is the node

fun transverseList(head:Node){
    var current : Node? = head
    while (current!= null) {
        println(current.name)
        current = current.next


    }
}


fun insertAtPosition(pos:Int,nodeToInsert:Node,head: Node){
    var counter = 1                  //
    var current:Node? = head
    while (counter < pos-1){
        current = current?.next
        counter ++
    }

    nodeToInsert.next = current?.next
    current?.next = nodeToInsert
}

fun insertAfterNode(name: String,nodeToInsert: Node,head: Node) {
    var current: Node? = head
    while (current!!.name != name) {
        current = current.next
    }
}

fun insertAtHead(nodeToInsert: Node,head: Node):Node{
    nodeToInsert.next = head
    return nodeToInsert
}

fun removeAtPosition(pos:Int,head: Node){
    var counter = 1
    var current:Node?=head

    while (counter<pos-1){
        current =current?.next
        counter ++
    }

    current?.next = current?.next?.next

}


fun findMiddleNode (head: Node):Node{
    var current:Node? = head
    var counter = 1
    while (current!=null){
        current = current.next
        counter ++
    }

    var mid = ceil(counter/2.0).toInt()
    current =head
    counter = 1
    while (counter < mid){
        current =current?.next
        counter++
    }
    return current!!
}

fun findMiddle(head: Node):Node {
    var fast: Node? = head
    var slow: Node? = head

    while (fast?.next!= null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    return  slow!!
}


fun findKthElementFromEnd(k:Int,head: Node):Node{
    var fast:Node? = head
    var slow:Node? = head
    var counter = 1
    while (counter<k){
        fast =fast?.next
        counter++
    }


    while (fast?.next!=null){
        fast =fast.next
        slow =slow?.next

    }
    return slow!!
}

fun detectCycle(head: Node):Node?{
    var visited = mutableSetOf<Node>()
    var current:Node? = head
    while (current != null){
        if (visited.contains((current))){
            return current
        }
        else {
            visited.add(current)
            current = current.next
        }
    }
    return  null
}

fun floydsCycle(head: Node):Node?{
    var fast : Node? =head
    var slow: Node? = head

    while (fast?.next!=null){
        fast = fast.next?.next
        slow = slow?.next

        if (fast == slow){
            break
        }
    }
    fast = head
    while (fast?.next!=null){
        fast = fast.next
        slow = slow?.next
        if (fast == slow){
            return  fast
        }
    }
    return null
}

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    if (!head || !head->next || k == 0) {
        return head; 
    }
    struct ListNode* temp = head;
    int c = 1;
    while (temp->next != NULL) {
        temp = temp->next;
        c++;
    }
    temp->next = head;
    k = k % c;
    int stepsToNewTail = c - k;
    struct ListNode* newTail = head;
    for (int i = 1; i < stepsToNewTail; i++) 
    {
        newTail = newTail->next;
    }
    head = newTail->next;
    newTail->next = NULL;

    return head;
}
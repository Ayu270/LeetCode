/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

struct TreeNode *recoverFromPreorder(char *traversal) {
  int vals[1000] = {0}, depths[1000] = {0}, len = 0;
  for (int i = 0; i < strlen(traversal);) {
    while (traversal[i] == '-') {
      depths[len]++;
      i++;
    }
    while (traversal[i] >= '0' && traversal[i] <= '9') {
      vals[len] = vals[len] * 10 + traversal[i] - '0';
      i++;
    }
    len++;
  }
  struct TreeNode *nodeList = calloc(len, sizeof(struct TreeNode));
  for (int i = 0; i < len; i++) {
    nodeList[i].val = vals[i];
    for (int j = i; j >= 0; j--) {
      if (depths[j] < depths[i]) {
        if (nodeList[j].left == NULL)
          nodeList[j].left = &nodeList[i];
        else
          nodeList[j].right = &nodeList[i];
        break;
      }
    }
  }
  return nodeList;
}
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

typedef struct {
    int x, y, height;
} Cell;

typedef struct {
    Cell* data;
    int front, rear, size, capacity;
} Queue;

Queue* createQueue(int capacity) {
    Queue* queue = (Queue*)malloc(sizeof(Queue));
    queue->data = (Cell*)malloc(capacity * sizeof(Cell));
    queue->front = 0;
    queue->rear = -1;
    queue->size = 0;
    queue->capacity = capacity;
    return queue;
}

void enqueue(Queue* queue, Cell cell) {
    queue->rear = (queue->rear + 1) % queue->capacity;
    queue->data[queue->rear] = cell;
    queue->size++;
}

Cell dequeue(Queue* queue) {
    Cell cell = queue->data[queue->front];
    queue->front = (queue->front + 1) % queue->capacity;
    queue->size--;
    return cell;
}

int isEmpty(Queue* queue) {
    return queue->size == 0;
}

int directions[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

int** highestPeak(int** isWater, int isWaterSize, int* isWaterColSize, int* returnSize, int** returnColumnSizes) {
    int m = isWaterSize, n = isWaterColSize[0];
    int** heightMap = (int**)malloc(m * sizeof(int*));
    for (int i = 0; i < m; i++) {
        heightMap[i] = (int*)malloc(n * sizeof(int));
        for (int j = 0; j < n; j++) {
            heightMap[i][j] = -1;
        }
    }

    // Initialize the BFS queue
    Queue* queue = createQueue(m * n);
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (isWater[i][j] == 1) {
                enqueue(queue, (Cell){i, j, 0});
                heightMap[i][j] = 0; // Water cells have height 0
            }
        }
    }

    // Perform BFS
    while (!isEmpty(queue)) {
        Cell current = dequeue(queue);
        int x = current.x, y = current.y, height = current.height;

        for (int d = 0; d < 4; d++) {
            int nx = x + directions[d][0];
            int ny = y + directions[d][1];

            // Check bounds and unvisited cells
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && heightMap[nx][ny] == -1) {
                heightMap[nx][ny] = height + 1;
                enqueue(queue, (Cell){nx, ny, height + 1});
            }
        }
    }

    free(queue->data);
    free(queue);

    *returnSize = m;
    *returnColumnSizes = (int*)malloc(m * sizeof(int));
    for (int i = 0; i < m; i++) {
        (*returnColumnSizes)[i] = n;
    }
    return heightMap;
}
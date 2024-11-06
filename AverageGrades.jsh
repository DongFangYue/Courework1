int[] average_grades(int[][] grades, int[] weights) {
    int numStudents = grades.length;
    int[] averages = new int[numStudents];
    
    for (int i = 0; i < numStudents; i++) {
        int sum = 0;
        for (int j = 0; j < weights.length; j++) {
            sum += grades[i][j] * weights[j];
        }
        averages[i] = sum / 100;
    }
    
    return averages;
}

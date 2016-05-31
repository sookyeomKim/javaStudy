package Jennifersoft;

import java.util.*;

/**
 * 김수겸
 * ikks06luck@gmail.com
 */

public class ProblemA {

    private void sort(String array[]) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(String[] array, int start, int end) {
        int i = start;                          // 왼쪽에서 시작하여 오른쪽으로 피봇보다 아스키코드값이 큰 값을 찾기 위한 인덱스입니다.
        int k = end;                            // 오른쪽에서 시작하여 왼쪽으로 피봇보다 아스키코드값이 작은 값을 찾기 위한 인덱스입니다.

        if (end - start >= 1) {             // 정렬의 추가 실행여부 확인(마지막과 시작의 인덱스가 같다는 것은 모든 정렬을 마치고 왔다는 의미이므로 바로 메소드를 벗어납니다)
            int pivot = (int) array[start].charAt(0);       // 배열의 맨 좌측을 피봇으로 설정합니다.

            while (k > i) {                 // i와 k가 엇갈리기 전까지 피봇을 기준으로 비교하여 swap합니다.
                while ((int) array[i].charAt(0) <= pivot && i <= end && k > i) {// 피봇의 아스키코드 값보다 큰 요소의 위치를 찾아 냅니다.
                    i++;
                }
                while ((int) array[k].charAt(0) > pivot && k >= start && k >= i) {// 피봇의 아스키코드 값보다 작은 요소의 위치를 찾아 냅니다.
                    k--;
                }
                if (k > i) {// 엇갈리기 전까지 피봇보다 아스키코드값이 큰 요소와 작은 요소를 서로 swap합니다.
                    swap(array, i, k);
                }
            }
            swap(array, start, k);          // 엇갈렸다면 피봇과 엇갈린 다음의 k(오른쪽에서 시작한 인덱스)와 swap하여 기준점으로 삼습니다. 혹은 피봇이 최대값일 경우 맨 뒤의 요소와 swap하여 정렬을 수행하도록 합니다.

            quickSort(array, start, k - 1); // 기준점의 왼쪽 partition을 재정렬합니다.
            quickSort(array, k + 1, end);   // 기준점의 오른쪽 partition을 재정렬합니다.
        }
    }

    private void swap(String[] array, int left, int right) {//왼쪽값과 오른쪽값을 swap하는 메소드
        String temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        //A번 문제의 접근 방법
        //1. 문자열을 알파벳순으로 재정렬합니다.(함께 중복된 문자열은 모아지게 됩니다.)N*logN
        //2. 문자열의 종류대로 크기를 구하여 Map에 저장합니다.N
        //3. 삽입된 문자와 삽입할 문자열의 크기를 비교하여 빈도수의 올림차순으로 삽입을 진행합니다.N*문자의 종류
        //N*logN + N + N*문자의 종류


        //수정
        //1.닥치고 문자들의 빈도수정보 먼저 저장. N(LinkedHashMap)이용
        //2.크기정보(key:문자,value:빈도수)를 문자순으로 퀵 정렬. 문자의 종류*log문자의 종류
        //3.크기정보(key:문자,value:빈도수)를 크기순으로 정렬. 문자의 종류*log문자의 종류
        //4.문자 빈도수대로 추가 N
        //2N + 2문자의 종류*log문자의 종류
        System.out.println("입력)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Boolean caseConfirm = false;

        for (int i = 0; i < input.length(); i++) {
            if ((int) input.charAt(i) < 65 || (int) input.charAt(i) > 90) {
                caseConfirm = true;
            }
        }

        if (input.length() > 1000000 || caseConfirm) {
            System.out.println("너무 길거나 대문자가 아니에요");
        } else {
            String[] inputArry = input.split("");   //입력된 문자열을 쪼개 배열로 만듭니다.

            //1.
            ProblemA quick = new ProblemA();
            quick.sort(inputArry);  //퀵정렬을 수행하여 문자열을 알파벳순으로 재정렬합니다.

            Map<String, Integer> elementSize = new HashMap<String, Integer>();  //각 문자의 크기를 담을 Map(단순 정보를 저장하고 저장을 검색하기 위한 용도로 쓰이므로 검색 기능이 좋은 HashMap사용)
            StringBuffer result = null;
            int sizeCount = 0;  //각 문자들의 크기
            int index = 0;  //입력된 문자열의 반복문을 위한 인덱스
            int beforeElementPos;   //결과값 List에서 마지막 문자그룹의 바로 전 요소의 위치
            String beforeElement;   //결과값 List에서 마지막 문자그룹의 바로 전 요소
            //2.
            for (int i = 0; i <= inputArry.length - 1; i++) {
                if (elementSize.containsKey(inputArry[i])) {    //Map에 크기정보가 있을 경우
                    sizeCount++;
                    elementSize.replace(inputArry[i], sizeCount);   //최신 카운트값으로 갱신합니다.
                } else {    //Map에 정보가 없을 경우
                    sizeCount = 1;
                    elementSize.put(inputArry[i], sizeCount);   //최초 크기정보는 1로 초기화합니다.
                }
            }

            //3.
            for (String element : inputArry) {
                if (result == null) { //List가 비어있을 경우
                    result = new StringBuffer();
                    result.append(element);//첫번째 문자를 삽입합니다.
                } else {
                    if (elementSize.get(result.substring(index - 1, index)) <= elementSize.get(element)) {   //삽입할 문자가 결과값 List의 마지막 문자보다 크기가 크거나 같은 경우 바로 삽입합니다.
                        result.append(element);
                    } else if (elementSize.get(result.substring(index - 1, index)) > elementSize.get(element)) { //삽입할 문자가 결과값 List의 마지막 문자보다 크기가 작을 경우
                        for (int i = result.length() - 1; ; i = beforeElementPos) {  //결과값 List의 마지막 문자위치; ; 결과값 List에서 다음 문자열의 마지막 문자 위치를 다음 인덱스로 지정(예를 들어 결과값이 AAABBBBCCCCC일 경우 C에서 B로 B에서 A로 넘어가게 합니다.)
                            beforeElementPos = result.indexOf(result.substring(i, i + 1)) - 1;   //결과값 List의 같은 문자열 중 첫번째 위치에서 -1을 하여 다른 문자열의 마지막 위치를 가리킵니다.
                            if (beforeElementPos < 0) { //결과값 List의 이전 문자열의 위치가 0보다 작다는 것은 삽입할 문자의 크기가 제일 작다는 것을 의미합니다.
                                result.insert(0, element);//첫번째에 삽입합니다.
                                break;
                            } else {
                                beforeElement = result.substring(beforeElementPos, beforeElementPos + 1);
                                if (elementSize.get(beforeElement) <= elementSize.get(element)) { //결과값 List의 이전 문자열의 크기보다 삽입할 문자의 크기가 크거나 갑을 경우
                                    result.insert(beforeElementPos + 1, element);//이전 문자열의 바로 다음 위치에 삽입합니다.
                                    break;
                                }
                            }
                        }
                    }
                }
                index++;
            }

            System.out.println("출력)");
            System.out.println(result);
        }
    }
}

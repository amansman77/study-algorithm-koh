# 압축

`Huffman Method with Run-Length Encoding`을 구현해본 공간입니다.

## 파일 설명

- `HuffmanEncoder.java`: 압축 서비스 클래스
- `HuffmanDecoder.java`: 압축 해제 서비스 클래스
- `HuffmanMethodWithRun.java`: 앱 클래스
- `Run.java`: super-symbol을 정의한 클래스
- `RunKey.java`: codeword를 해시자료구조로 활용하기 위한 키 클래스
- `MinHeap.java` : 최소 우선순위 큐(minimum priority queue)를 구현한 클래스
- `ByteBuffer.java`: 바이트단위 파일쓰기를 위한 클래스
- `ByteUtil.java`: 바이트 사용을 위한 유틸 클래스
- `input-data.txt`: 샘플 데이터 파일
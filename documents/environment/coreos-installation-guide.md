# coreos 설치가이드

기존 CoreOS가 더 이상 지원되지 않아 페도라 코어OS 설치 가이드 작성

## 맥OS + VMWare의 경우

1. 호스트에서 CoreOS ssh 접속을 위한 비밀키와 공개키를 생성
```bash
# id_rsa 파일이 이미 존재 할 수 있으니 id_coreos와 같이 다른 이름으로 생성  
ssh-keygen -t rsa -b 4096 -C "core_user" -f ~/.ssh/id_coreos
```

1. 호스트 머신에 ssh 접속키가 포함된 ignition.json 파일 생성
```json
{
  "ignition": {
    "version": "3.2.0"
  },
  "passwd": {
    "users": [
      {
        "name": "core",
        "sshAuthorizedKeys": [
            "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDa2mtbhJ9sx7GoiWbfwoL24/cdo3aDCad9rkjm4l4vCvCIfQI7w0Wqheu6iq1FvkjLkhnG9UWuBLjle1zEWYTRxy9NIrnNn1SInZJZxEcM3TnrwaK42mRQDhzSOLmslt8sKBbpkwYF3XTSOg45CBHYoAcUqCylHXPj+WTryGKFVFnxPeSwrpd32x4/wd6kjvq79MDl4gOkY1VMOVogaDan/hNkK6BxGoMWfbRQPO6tzpnfGAmFzUllPuNAFFif09pVki8TO+ogjddyKQyPkn+XUFhWf3Z1vbWEgxnAakqRRHmnD6bVBCJxc7tE5gOfSloO0q8Zl1B3JeD/4JHy6uxBNLdBmVDsxXavcrg1cNcHQdNN9R3h2+SpVwGBzbADQbzQD60IaqL12HNYaCYpZ3DxU3oOQWT9i0JnJLDdojn9tiGH6gmi5qGxvCjmT2CAIKNQ/WSH7Kojw8XBTA5HNMtuBWdKvn6Ytp3mlpFm4KBcQqju0SpOP7xbyLWISog81Z2HTI/ty2VB/NCY305VK9kMZRKve4uMSAI960nI4nn/SpiZkAIQFC1UxbtoOv7wCCiqBZn59gHvGnu38Z9+iV9oxyLyNTxo+Ze4NQ08XrWFFBWlLPZy0izg5LrmkA1JFns4MYi+bgLeXaKIBk+5ojuxx81k3oVcQ2aaWgc6vKOK5Q== core_user"       
        ]
      }
    ]
  }
}
```

1. ignition.json 파일을 가상머신에서 접속 할 수 있게 호스트 머신에서 서버 실행 (아래 예제는 파이썬을 이용한 방법)
```bash
# 먼저 ignition.json 파일이 있는 디렉토리로 이동
python -m http.server 8000

# curl http://localhost:8000/ignition.json로 이그니션 파일이 정상적으로 접속되는지 확인
curl http://localhost:8000/ignition.json
```

1. [CoreOS Live DVD ISO 파일 다운로드](https://fedoraproject.org/coreos/download?stream=stable#download_section)

1. VMWare에서 새 가상머신 생성하여 위에서 다운로드 받은 ISO 파일을 연결하고 부팅

1. 가상머신이 부팅되면, ignition.json 파일을 다운로드
```bash
# 호스트의 ignition.json 파일을 다운로드
curl http://<호스트머신의IP>:8000/ignition.json -o ./ignition.json
```

1. ignition.json 파일을 이용하여 설치 진행
```bash
# ignition.json 파일을 이용하여 설치 진행 (아래 예제는 /dev/sda에 설치, 경우에 따라 /dev/nvme0n1 등으로 변경)
sudo coreos-installer install /dev/sda --ignition-file ./ignition.json
```

1. 설치가 완료되면 CoreOS 가상머신 재부팅
```bash
sudo reboot
```

1. 설치가 완료되면, ssh로 접속하여 확인 (가상 머신의 ip는 coreos가 부팅되면 화면에 표시됨)
```bash
ssh -i ~/.ssh/id_coreos core@<가상머신의IP>
```
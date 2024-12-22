# 브랜치 관리 전략
- 기본적인 기능 개발이 완료되어 최초 배포버전이 만들어지면 [git flow](https://techblog.woowahan.com/2553/) 또는 [github flow](https://docs.github.com/ko/get-started/using-github/github-flow)와 유사한 형태로 진행합니다.

### 필수 브랜치
- main : 메인 브랜치
- develop : 개발 브랜치

### 선택 브랜치
작업에 따라 유연하게 작성하나 다음과 같이 알아 볼 수 있게 명명해야 합니다.
- feature : 기능 개발 브랜치 (예: feature/root_ca_feature)
- release : 배포 전 테스트를 위한 브랜치 (예: release/auction_v1.0)
- fix : 기존 기능에 대한 버그 수정 브랜치 (예: fix/ca_chain)
- hotfix : 빠르게 반영해야하는 핫픽스가 올라가는 브랜치 (예: hotfix/fix_ca_chain)
- renewal : 대대적인 구조 변경 등 리뉴얼 작업인 경우 (예: renewal/renewal_init_sequence)
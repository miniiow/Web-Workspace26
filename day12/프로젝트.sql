-- 게시판 테이블 생성(t_board)
create table t_board(
    no  number(5) primary key
    , title varchar2(1000) not null
    , writer varchar2(200) not null
    , content varchar2(4000) not null
    , view_cnt number(5) default 0
    , reg_date date default sysdate
);

-- 시퀀스 생성
create sequence seq_t_board_no nocache;

select * from t_board;

insert into t_board(no, title, writer, content)
 values(seq_t_board_no.nextval, '제목이다', '홍길동', '여긴 내용부...');
 
insert into t_board(no, title, writer, content) 
values(seq_t_board_no.nextval, '하하하', '홍길순', 'ㅋㅋㅋㅋㅋ');

commit;
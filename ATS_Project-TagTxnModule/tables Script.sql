
create sequence ats_user_seq start with 1 increment by  1;
create sequence batch_run_seq start with 1 increment by  1;
create sequence batch_summry_seq start with 1 increment by  1;
create sequence tag_gen_seq start with 1 increment by  1;
create sequence txn_no_seq start with 10000001 increment by  1;

    
    create table batch_run_dtls (
       run_id number(19,0) not null,
        batch_name varchar2(255 char),
        create_by varchar2(255 char),
        create_dt timestamp,
        end_dt date,
        run_status varchar2(255 char),
        start_dt date,
        update_dt timestamp,
        update_by varchar2(255 char),
        primary key (run_id)
    );
    
    create table batch_run_summary (
       summary_id number(19,0) not null,
        batch_name varchar2(255 char),
        create_by varchar2(255 char),
        create_dt timestamp,
        summary_dtls varchar2(255 char),
        update_by varchar2(255 char),
        update_dt timestamp,
        primary key (summary_id)
    );
    
    create table tag_master (
       tag_seq number(19,0) not null,
        create_by varchar2(255 char),
        create_dt timestamp,
        tag_bal double precision,
        tag_expiry_dt date,
        tag_id number(19,0),
        tag_start_dt date,
        update_by varchar2(255 char),
        update_dt timestamp,
        user_id number(19,0),
        vhcl_reg_num varchar2(7 char),
        vehicle_type varchar2(15 char),
        primary key (tag_seq)
    );
    
    create table tag_tx_trigger (
       trg_id number(19,0) not null,
        create_by varchar2(255 char),
        create_dt timestamp,
        remainder_msg_sw varchar2(255 char),
        tag_id number(19,0),
        toll_amt double precision,
        toll_plaza_id varchar2(255 char),
        tx_failure_rsn varchar2(255 char),
        tx_status varchar2(255 char),
        update_by varchar2(255 char),
        update_dt timestamp,
        vhcl_reg_num varchar2(7 char),
        primary key (trg_id)
    );
    
    create table user_master (
       user_id number(19,0) not null,
        create_dt timestamp,
        created_by varchar2(255 char),
        dob date,
        email_id varchar2(50 char),
        first_name varchar2(50 char),
        gender varchar2(10 char),
        last_name varchar2(50 char),
        moblie_num number(19,0),
        update_dt timestamp,
        updated_by varchar2(255 char),
        primary key (user_id)
    );